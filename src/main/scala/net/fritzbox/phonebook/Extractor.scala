package net.fritzbox.phonebook

import scala.io.Source
import scala.sys.process.ProcessBuilder.FileBuilder

/**
 * Created by didlich on 9/25/15.
 */
class Extractor(inputFile: String, outputFile: String) {

  def run(): Unit = {
    println("Input-File:  " + inputFile)
    println("Output-File: " + outputFile)

    val fileBuilder = new StringBuilder()
    Source.fromFile(inputFile).getLines().foreach(
      (str: String) => fileBuilder.append(str)
    )

    val xmlString = Converter.toAscii(extractHex(fileBuilder))

    var xmlBuilder = new StringBuilder()
    xmlBuilder.append(XmlHelper.removeXmlHeader(xmlString))

    val xmlNode = XmlHelper.wrapInSingleXmlNode(xmlBuilder).toString()
    val phoneBookXml = scala.xml.XML.loadString(XmlHelper.prettifyXml(xmlNode))

    /*
     * extract only the phonebook without the owner attribute
     */
    for {
      phoneBookNode <- (phoneBookXml \ "phonebook") if (phoneBookNode.attribute("owner").isEmpty)
    } yield {
      scala.xml.XML.save(
        outputFile,
        phoneBookNode,
        "UTF-8",
        true,
        null
      )
    }
  }

  private def extractHex(fileBuilder: StringBuilder): String = {
    // find :phonebook mark
    // then following any char and
    // ending with ****
    val phoneBookR = """:phonebook(.*?)\*\*\*\*""".r

    val phoneBookHexBlock = (phoneBookR findFirstIn fileBuilder.toString())

    val phoneBookHex = phoneBookHexBlock.toList(0)
      .replace(":phonebook", "")
      .replace("****", "")

    phoneBookHex
  }


}

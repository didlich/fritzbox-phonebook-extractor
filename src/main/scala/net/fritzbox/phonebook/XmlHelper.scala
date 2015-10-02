package net.fritzbox.phonebook

/**
 * Created by didlich on 9/25/15.
 */
object XmlHelper {

  def wrapInSingleXmlNode(sb: StringBuilder): StringBuilder = {
    val prefix = "<avm>"
    val suffix = "</avm>"
    sb.insert(0, prefix)
    sb.append(suffix)
  }

  def removeXmlHeader(xmlString: String): String = {
    val xmlHeaderR = """\<\?xml[\S\s].*utf-8\"\>""".r

    (xmlHeaderR findAllIn xmlString).toList

    val xmlNodeString = xmlHeaderR replaceFirstIn(xmlString, "")
    xmlNodeString
  }

  def prettifyXml(xmlNode: String): String = {
    // max width: 80 chars
    // indent:     2 spaces
    val prettyPrinter = new scala.xml.PrettyPrinter(80, 2)
    val xml = scala.xml.XML.loadString(xmlNode)
    val prettyXml = prettyPrinter.format(xml)
    prettyXml
  }
}

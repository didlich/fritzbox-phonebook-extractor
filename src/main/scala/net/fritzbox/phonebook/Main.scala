package net.fritzbox.phonebook

import java.io.File
import java.nio.file.{Paths, Files}

/**
 * Created by didlich on 9/25/15.
 */
object Main {
  def main(args: Array[String]) = {
    val usage =
      """
        |usage: provide the input file and output directory
        |
        |-i , the input file to be processed, is the .export from fritzbox
        |-o , the output path to the phonebook.xml file
      """.stripMargin

    if (args.length != 4) {
      println(usage);
      System.exit(0)
    }

    val inputFilePath = args(1)
    val outputDir = args(3)
    val outputFilePath = Paths.get(outputDir, "phonebook.xml").toAbsolutePath.toString

    if (!Files.exists(Paths.get(inputFilePath))) {
      println(inputFilePath + " doesn't eixist")
      System.exit(-1)
    }

    val dir: File = new File(outputDir)

    if (!dir.exists()) {
      println(outputDir + " doesn't exist")
      System.exit(-1)
    }

    val extractor = new Extractor(inputFilePath, outputFilePath)
    extractor.run()
  }
}

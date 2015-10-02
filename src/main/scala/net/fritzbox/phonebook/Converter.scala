package net.fritzbox.phonebook

import javax.xml.bind.DatatypeConverter

/**
 * Created by didlich on 9/25/15.
 */
object Converter {

  def toAscii(hex: String): String = {
    var decodedHex: Array[Byte] = DatatypeConverter.parseHexBinary(hex)
    val decodedString: String = new String(decodedHex, "UTF-8")
    decodedString
  }
}

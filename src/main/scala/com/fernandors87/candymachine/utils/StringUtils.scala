package com.fernandors87.candymachine.utils

import java.util.regex.Pattern

object StringUtils {

  private val squishPattern = Pattern.compile("\\s+")

  /**
    * A substring delimited by the range as index offsets
    *
    * Positive values count the offsets from the start of the string,
    * while negative values count the offsets from the end
    *
    * @example {{{
    * import com.fernandors87.candymachine.StringUtils._
    * offset("qwerty", 1, 4)     // => Some("wert")
    * offset("asdfgh", 1, -2)    // => Some("sdfg")
    * offset("zxcvbn", -5, 4)    // => Some("xcvb")
    * offset("ytrewq", -5, -2)   // => Some("trew")
    * offset("hgfdsa", 2, 100)   // => Some("fdsa")
    * offset("nbvcxz", -100, -3) // => Some("nbvc")
    * offset("", 0, 0)           // => None
    * }}}
    *
    * @param text the full string
    * @param from start offset index
    * @param to end offset index
    * @return the substring for the given offset range, if possible
    */
  def offset(text: String, from: Int, to: Int): Option[String] = {
    if (text.isEmpty) return None

    val start = absIndex(text, from)
    val end = absIndex(text, to)

    if (end >= start) Some(text.substring(start, end + 1))
    else None
  }

  /**
    * Trim the given string and replace space characters by a single whitespace.
    *
    * This method consider a space character any of the following:
    * - A space character(" ")
    * - A tab character("\t")
    * - A carriage return character("\r")
    * - A new line character("\n")
    * - A vertical tab character("\x0B")
    * - A form feed character("\f")
    *
    * @example {{{
    * import com.fernandors87.candymachine.StringUtils._
    * squish("    there's    no \n free lunch     ") // => "there's no free lunch"
    * }}}
    *
    * @param text the dirty string
    * @return the clean string
    */
  def squish(text: String): String = {
    squishPattern.matcher(text.trim).replaceAll(" ")
  }

  private def absIndex(text: String, offset: Int): Int = {
    if (offset >= text.length) text.length - 1
    else if (offset >= 0 && offset < text.length) offset
    else if (offset < 0 && offset >= -text.length) text.length + offset
    else 0
  }
}

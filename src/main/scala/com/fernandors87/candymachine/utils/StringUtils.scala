package com.fernandors87.candymachine.utils

object StringUtils {

  /**
    * A substring delimited by the range as index offsets
    *
    * Positive values count the offsets from the start of the string,
    * while negative values count the offsets from the end
    *
    * @example {{{
    * import com.fernandors87.candymachine.StringUtils
    * StringUtils.offset("qwerty", 1, 4)     // => Some("wert")
    * StringUtils.offset("asdfgh", 1, -2)    // => Some("sdfg")
    * StringUtils.offset("zxcvbn", -5, 4)    // => Some("xcvb")
    * StringUtils.offset("ytrewq", -5, -2)   // => Some("trew")
    * StringUtils.offset("hgfdsa", 2, 100)   // => Some("fdsa")
    * StringUtils.offset("nbvcxz", -100, -3) // => Some("nbvc")
    * StringUtils.offset("", 0, 0)           // => None
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

  private def absIndex(text: String, offset: Int): Int = {
    if (offset >= text.length) text.length - 1
    else if (offset >= 0 && offset < text.length) offset
    else if (offset < 0 && offset >= -text.length) text.length + offset
    else 0
  }
}




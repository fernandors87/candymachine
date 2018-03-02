package com.fernandors87.candymachine.pimps

import com.fernandors87.candymachine.utils.StringUtils

object StringPimps extends StringPimps

trait StringPimps {

  implicit class SweetString(under: String) {

    def offset(from: Int, to: Int): Option[String] = StringUtils.offset(under, from, to)

    def squish: String = StringUtils.squish(under)
  }
}

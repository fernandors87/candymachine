package com.fernandors87.candymachine.pimps

import com.fernandors87.candymachine.utils.StringUtils

object StringPimps extends StringPimps

trait StringPimps {

  implicit class SweetString(under: String) {

    def offset(from: Int, to: Int) = StringUtils.offset(under, from, to)
  }
}

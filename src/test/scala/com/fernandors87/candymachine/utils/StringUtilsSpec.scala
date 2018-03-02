package com.fernandors87.candymachine.utils

import com.fernandors87.candymachine.BaseSpec

class StringUtilsSpec extends BaseSpec {

  import com.fernandors87.candymachine.utils.StringUtils._

  val text = "abcdef"

  describe(".offset") {
    it("do not give a substring of an empty string") {
      offset("", 0, 0) shouldBe None
    }

    it("give a substring for a positive..positive index offset range") {
      offset(text, 0, 5) shouldBe Some("abcdef")
      offset(text, 1, 4) shouldBe Some("bcde")
      offset(text, 2, 3) shouldBe Some("cd")
      offset(text, 3, 2) shouldBe None
    }

    it("give a substring for a positive..negative index offset range") {
      offset(text, 0, -1) shouldBe Some("abcdef")
      offset(text, 1, -2) shouldBe Some("bcde")
      offset(text, 2, -3) shouldBe Some("cd")
      offset(text, 3, -4) shouldBe None
    }

    it("give a substring for a negative..positive index offset range") {
      offset(text, -6, 5) shouldBe Some("abcdef")
      offset(text, -5, 4) shouldBe Some("bcde")
      offset(text, -4, 3) shouldBe Some("cd")
      offset(text, -3, 2) shouldBe None
    }

    it("give a substring for a negative..negative index offset range") {
      offset(text, -6, -1) shouldBe Some("abcdef")
      offset(text, -5, -2) shouldBe Some("bcde")
      offset(text, -4, -3) shouldBe Some("cd")
      offset(text, -3, -4) shouldBe None
    }

    it("give the substring for an out of bound index offset range") {
      offset(text, 0, 100) shouldBe Some("abcdef")
      offset(text, 2, 100) shouldBe Some("cdef")
      offset(text, -100, -1) shouldBe Some("abcdef")
      offset(text, -100, -3) shouldBe Some("abcd")
      offset(text, -100, 100) shouldBe Some("abcdef")
    }
  }
}

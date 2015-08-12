package org.rubik.sandbox.common.util

import org.scalatest._

import scala.sys.process.Process

class FileUtilsSpec extends FlatSpec {

  "reverse file" should "head line at source file equals last line at target file" in {
    SystemUtils.elapsedTime {
      val sourceFile = "/Users/xiajinxin/Desktop/res.txt"
      val targetFile = "/Users/xiajinxin/Desktop/target.txt"
      FileUtils.split(sourceFile)
      FileUtils.merge(targetFile)
    }

    val headOfSourceFile = "head -n 1 /Users/xiajinxin/Desktop/res.txt"
    val tailOfTargetFile = "tail -n 1 /Users/xiajinxin/Desktop/target.txt"

    val headCmd = Process(Seq("/bin/bash", "-c", headOfSourceFile))
    val tailCmd = Process(Seq("/bin/bash", "-c", tailOfTargetFile))
    assert((headCmd !!) == (tailCmd !!))
  }
}
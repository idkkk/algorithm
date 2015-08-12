package org.rubik.sandbox.common.util

import org.scalatest._

import org.rubik.sandbox.common.util.FileUtils._
import scala.sys.process.Process

class FileUtilsSpec extends FlatSpec {

  "reverse file" should "head line at source file equals last line at target file" in {
    val sourceFile = "/Users/xiajinxin/Desktop/app.log"
    val targetFile = "/Users/xiajinxin/Desktop/target.txt"

    SystemUtils.elapsedTime {
      merge(split(sourceFile), targetFile)
    }

    val headOfSourceFile = s"head -n 1 ${sourceFile}"
    val tailOfTargetFile = s"tail -n 1 ${targetFile}"

    val headCmd = Process(Seq("/bin/bash", "-c", headOfSourceFile))
    val tailCmd = Process(Seq("/bin/bash", "-c", tailOfTargetFile))
    assert((headCmd !!) == (tailCmd !!))
  }
}
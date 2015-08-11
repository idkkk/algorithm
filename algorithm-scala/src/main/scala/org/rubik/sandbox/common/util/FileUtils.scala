package org.rubik.sandbox.common.util

import java.io.File
import java.io.PrintWriter

import com.google.common.base.{Strings, Charsets}
import com.google.common.io.Files
import scala.io.Source
import scala.sys.process._

/**
 * 文件工具类.
 *
 * @author xiajinxin
 * @since 2015-08-11
 */
object FileUtils {
  /**
   * 切割后的文件存储的临时目录
   */
  private val TEMP_DIR = "/Users/xiajinxin/Desktop/data/"

  /**
   * 按行切割成小文件(实现：split -l 2000 -d 3 FILE_NAME).
   * @param sourcePath 原文件全路径
   * @param lines 切割的行数
   * @param spanLength 小文件名长度
   * @return
   */
  def split(sourcePath: String, lines: Int = 2000, spanLength: Int = 3): Unit = {
    lazy val source = Source.fromFile(sourcePath)
    try {
      var i = 1
      for (block <- source.getLines.sliding(lines, lines).toStream) {
        val content = block.view.reverse.mkString("\n")
        val file = new File(TEMP_DIR + Strings.padStart(i.toString, spanLength, '0'))
        Files.write(content, file, Charsets.UTF_8)
        i += 1
      }
    } finally {
      source.close()
    }
  }

  /**
   * 按文件名倒序合并生成新文件.
   * @param targetPath 目标文件全路径
   */
  def merge(targetPath: String): Unit = {
    val cmd = s"cd ${TEMP_DIR}; find * | sort -r | xargs cat"
    val ret = Process(Seq("/bin/bash", "-c", cmd))
    ret #> new File(targetPath) !
  }
}

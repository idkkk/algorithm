package org.rubik.sandbox.common.util

import java.io.File

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
   * 按行切割成小文件(实现：split -l 2000 -d 3 FILE_NAME).
   * @param sourcePath 原文件全路径
   * @param lines 切割的行数
   * @param spanLength 小文件名长度
   * @param dataDir 切割后的文件存储的临时目录
   * @return 切割后的小文件存储目录
   */
  def split(sourcePath: String, lines: Int = 50000, spanLength: Int = 3, dataDir: String = "/Users/xiajinxin/Desktop/data/"): String = {
    lazy val source = Source.fromFile(sourcePath)
    try {
      var i = 1
      source.getLines.sliding(lines, lines).toStream.map( block => {
          val content = block.view.reverse.mkString(System.getProperty("line.separator"))
          val file = new File(dataDir + Strings.padStart(i.toString, spanLength, '0'))
          Files.write(content, file, Charsets.UTF_8)
          i += 1
        }
      )
    } finally {
      source.close()
    }

    dataDir
  }

  /**
   * 按文件名倒序合并生成新文件(实现：find * | sort -r | xargs cat > target.txt).
   * @param dataDir 合并源文件目录
   * @param targetPath 目标文件全路径
   */
  def merge(dataDir: String, targetPath: String): Unit = {
    val cmd = s"cd ${dataDir}; find * | sort -r | xargs cat"
    val ret = Process(Seq("/bin/bash", "-c", cmd))
    ret #> new File(targetPath) !
  }
}

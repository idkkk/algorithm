package org.rubik.sandbox.common.util

import java.io.{BufferedWriter, FileWriter, File}
import java.util.UUID

import com.google.common.base.{Strings, Charsets}
import com.google.common.collect.Lists
import com.google.common.io.Files
import scala.io.Source

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
  def split(sourcePath: String, lines: Int = 50000, spanLength: Int = 3, dataDir: String = "/Users/xiajinxin/Desktop/data/"): List[String] = {
    val dataFile = using(Source.fromFile(sourcePath)) {
      source => {
          for(lines <- source.getLines.sliding(lines, lines).toStream) yield {
            val fileName = dataDir + UUID.randomUUID().toString
            val content = lines.view.reverse.mkString(System.getProperty("line.separator"))
            val file = new File(fileName)
            Files.write(content, file, Charsets.UTF_8)

            fileName
          }
        }.toList
    }
    dataFile
  }

  /**
   * 按文件名倒序合并生成新文件(实现：find * | sort -r | xargs cat > target.txt).
   * @param files 需要进行合并的源文件集合
   * @param targetPath 目标文件全路径
   */
  def merge(files: List[String], targetPath: String): Unit = {
    val bw = new BufferedWriter(new FileWriter(new File(targetPath), true))
    files.reverse.foreach(fileName => bw.write(Files.toString(new File(fileName), Charsets.UTF_8)))
    bw.close
  }

  /**
   * 自动资源释放
   * @param resource 需要释放的资源
   * @param f 执行的函数
   * @tparam A 需要释放的资源类型
   * @tparam B 返回值
   * @return 函数执行结果
   */
  def using[A <: { def close(): Unit }, B](resource: A)(f: A => B): B = {
    try {
      f(resource)
    } finally {
      if (resource != null)
        resource.close()
    }
  }
}

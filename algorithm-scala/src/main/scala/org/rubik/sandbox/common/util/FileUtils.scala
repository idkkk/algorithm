package org.rubik.sandbox.common.util

import java.io.{PrintWriter, File}
import java.util.UUID

import com.google.common.base.{Charsets}
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
   * @return 切割后的小文件存储目录
   */
  def split(sourcePath: String): List[String] = {
    val dataDir = "/Users/xiajinxin/Desktop/data/"

    /**
     * 生成片段文件名
     * @return 生成的片段文件名
     */
    def fileNameOfFragment: (Seq[String]) => String = {
      block => {
        val fileName = dataDir + UUID.randomUUID().toString
        val content = block.view.reverse.mkString(System.getProperty("line.separator"))
        val file = new File(fileName)
        Files.write(content, file, Charsets.UTF_8)

        fileName
      }
    }

    val result = using(Source.fromFile(sourcePath)) {
      source => source.getLines.sliding(50000, 50000).toStream.map(fileNameOfFragment).toList
    }
    result
  }

  /**
   * 按文件名倒序合并生成新文件(实现：find * | sort -r | xargs cat > target.txt).
   * @param files 需要进行合并的源文件集合
   * @param targetPath 目标文件全路径
   */
  def merge(files: List[String], targetPath: String): Unit = {
    using(new PrintWriter(new File(targetPath))) {
      pw => files.reverse.foreach {
        fileName => pw.append(Files.toString(new File(fileName), Charsets.UTF_8))
      }
    }
  }

  /**
   * 组合split， merge.
   * @param sourceFile 原文件
   * @param targetFile 目标文件
   */
  def reverseFile(sourceFile: String, targetFile: String): Unit = {
    merge(split(sourceFile), targetFile)      // TODO: split(sourceFile) andThen merge(targetFile)
  }

  /**
   * 自动资源释放.
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

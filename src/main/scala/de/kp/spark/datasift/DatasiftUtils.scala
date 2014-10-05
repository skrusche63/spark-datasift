package de.kp.spark.datasift
/* Copyright (c) 2014 Dr. Krusche & Partner PartG
 * 
 * This file is part of the Spark-DataSift project
 * (https://github.com/skrusche63/spark-datasift).
 * 
 * Spark-DataSift is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * Spark-DataSift is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with
 * Spark-DataSift. 
 * 
 * If not, see <http://www.gnu.org/licenses/>.
 */

import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.StreamingContext

import org.apache.spark.streaming.dstream.ReceiverInputDStream
import com.datasift.client.stream._

object DatasiftUtils {
  
  def createStream(
      ssc: StreamingContext,
      appkey:String,
      user:String,
      query:String,      
      storageLevel: StorageLevel = StorageLevel.MEMORY_AND_DISK_SER_2
    ): ReceiverInputDStream[Interaction] = {
    new DatasiftInputDStream(ssc, appkey,user,query,storageLevel)
  
  }

}
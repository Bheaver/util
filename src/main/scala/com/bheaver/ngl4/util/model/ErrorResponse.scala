package com.bheaver.ngl4.util.model

import scala.beans.BeanProperty

case class ErrorResponse(@BeanProperty var errorCode:Int, @BeanProperty var errorDescription:String)

name := """pricing-engine"""
organization := "com.reciprocity"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.7"

libraryDependencies += guice
libraryDependencies += "com.scireum" % "parsii" % "4.0"


name := "fritzbox-phonebook-extractor"

version := "1.0.0"

scalaVersion := "2.11.7"

exportJars := true

resolvers ++= Seq(
  "Typesafe" at "http://repo.typesafe.com/typesafe/releases/",
  "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"
)

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" % "1.0.3"
)


proguardSettings
ProguardKeys.proguardVersion in Proguard := "5.0"
ProguardKeys.merge in Proguard := true
ProguardKeys.mergeStrategies in Proguard += ProguardMerge.first("META-INF/MANIFEST.MF")
ProguardKeys.inputFilter in Proguard := { file => None }

ProguardKeys.options in Proguard ++= Seq("-dontnote", "-dontwarn", "-ignorewarnings", "-dontoptimize")
ProguardKeys.options in Proguard += ProguardOptions.keepMain("net.fritzbox.phonebook.Main")


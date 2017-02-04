import sbt.Keys._
import sbt.{Credentials, Path}

organization := "org.helianto"

version := "1.3.4.RELEASE"

sbtVersion := "0.13.9"

scalaVersion := "2.11.8"

lazy val root = (project in file("."))
  .enablePlugins(JavaServerAppPackaging)
  .settings(commonSettings)
  .settings(
    name := "helianto-material-skin",
    libraryDependencies ++= Seq(
      "org.projectlombok"                  % "lombok"                         % "1.16.8",
      "org.springframework.boot"           % "spring-boot-starter-web"        % "1.4.1.RELEASE",
      "org.springframework.boot"           % "spring-boot-starter-data-jpa"   % "1.4.1.RELEASE",
      "org.springframework.boot"           % "spring-boot-starter-security"   % "1.4.1.RELEASE",
      "org.springframework.boot"           % "spring-boot-starter-freemarker" % "1.4.1.RELEASE",
      "org.springframework.security.oauth" % "spring-security-oauth2"         % "2.0.11.RELEASE",
      "org.springframework.security"       % "spring-security-jwt"            % "1.0.5.RELEASE",
      "org.springframework"                % "spring-orm"                     % "4.3.3.RELEASE", // fixme
      "com.zaxxer"                         % "HikariCP"             % "2.4.3",
      "com.h2database"                     % "h2"                   % "1.4.192",
      "mysql"                              % "mysql-connector-java" % "5.1.26",
      "commons-io"                         % "commons-io"           % "2.4",
      "io.springfox"                       % "springfox-swagger2"   % "2.6.0",
      "io.springfox"                       % "springfox-swagger-ui" % "2.6.0",
      "io.swagger"                         % "swagger-core"         % "1.5.10",
      "org.scalatest"                     %% "scalatest"            % "3.0.0"   % "test",
      "org.mockito"                        % "mockito-all"          % "1.10.19" % "test",
      "org.slf4j"                          % "slf4j-simple"         % "1.7.14"
    )
  )

libraryDependencies ++= Seq(
  "org.webjars.bower" % "angular"              % "1.6.1",
  "org.webjars.bower" % "angular-sanitize"     % "1.6.1",
  "org.webjars.bower" % "angular-resource"     % "1.6.1",
  "org.webjars.bower" % "angular-animate"      % "1.6.1",
  "org.webjars.bower" % "angular-aria"         % "1.6.1",
  "org.webjars.bower" % "angular-i18n"         % "1.6.1",
  "org.webjars.bower" % "angular-material"     % "1.1.1",
  "org.webjars.bower" % "angular-loading-bar"  % "0.9.0",
  "org.webjars.bower" % "angular-moment"       % "1.0.1",
  "org.webjars.bower" % "slimScroll"           % "1.3.3"  exclude("org.webjars.bower", "jquery"),
  "org.webjars.bower" % "bootstrap"            % "3.3.7"  exclude("org.webjars.bower", "jquery"),
  "org.webjars.bower" % "jquery"               % "2.2.4",
  "org.webjars.bower" % "fontawesome"          % "4.6.3",
  "org.webjars.bower" % "wowjs" % "1.1.2",
  "org.webjars.bower" % "tether" % "1.3.7",
  "org.webjars.bower" % "smooth-scroller" % "0.1.2"
)

lazy val commonSettings = Seq(
  resolvers  ++= Seq(
    "Helianto Releases"  at "s3://maven.helianto.org/release",
    "Helianto Snapshots" at "s3://maven.helianto.org/snapshot",
    "Helianto Development" at "s3://maven.helianto.org/devel"
  ),
  libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "3.0.0" % "test",
    "org.mockito" % "mockito-all" % "1.10.19" % "test"
  ),
  publishTo := {
    val helianto = "s3://maven.helianto.org/"
    if (version.value.trim.endsWith("SNAPSHOT"))
      Some("Helianto Snapshots" at helianto + "snapshot")
    else if (version.value.trim.endsWith("RELEASE"))
      Some("Helianto Releases" at helianto + "release")
    else
      Some("Helianto Development"  at helianto + "devel")
  },
  credentials += Credentials(Path.userHome / ".sbt" / ".s3credentials"),
  publishMavenStyle := true
)

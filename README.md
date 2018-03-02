## Usage

For now this project has no maven repository. So you'll need to add the dependency the ugly way:

```scala
// build.sbt

lazy val root = (project in file("."))
  .settings(
    name := "Your project name",
    scalaVersion := "2.12.4")
  .dependsOn(RootProject(uri("git://github.com/fernandors87/candymachine.git#master")))
```

CandyMachine comes in a lot of flavours. So you can pick up whatever suits you.

- Utility objects

      import com.fernandors87.candymachine.utils.StringUtils
      StringUtils.offset("qwerty", 2, -3)

- Import pimped traits to limit the sugar scope
      
      import com.fernandors87.candymachine.pimps.StringPimps

      object PimpedWithScope extends StringPimps {
        val text = "qwerty".offset(2, -3)
      }

      println(PimpedWithScope.text)

- Import only specialized pimps

      import com.fernandors87.candymachine.pimps.StringPimps._
      "qwerty".offset(2, -3)

- Diabetes

      import com.fernandors87.candymachine.pimps._
      "qwerty".offset(2, -3)

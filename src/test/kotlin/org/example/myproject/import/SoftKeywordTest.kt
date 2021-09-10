package org.example.myproject.import

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import io.kotest.spring.Components
import io.kotest.spring.UserService
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

class IllegalPackageNameTest : FunSpec() {
   init {
      test("should throw clear error on illegal package name") {
         shouldThrowAny {
            SpringExtension.intercept(this@IllegalPackageNameTest) {}
         }.message shouldBe "Spec package name cannot contain a java keyword: import,finally,catch,const,final,inner,protected,private,public"
      }
   }
}

@SpringBootTest
@ContextConfiguration(classes = [(Components::class)])
private class SoftKeywordTest(service: UserService) : StringSpec({
   extensions(SpringExtension)
   "empty test should always be green" {
   }
})

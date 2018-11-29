package com.wisely.highlight_spring4.ch3.fortest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wisely.highlight_spring4.ch3.fortest.TestConfig;

/**
 * 1、SpringJUnit4ClassRunner在JUnit环境下提供SpringTestContext Framework的功能。
 * 2、@ContextConfiguration用来加载配置ApplicationContext，其中classes属性用来加载配置类
 * 3、@ActiveProfiles用来声明活动的profile。
 * 4、可使用普通的@Autowired注入Bean
 * 5、测试代码，通过JUnit的Assert来校验结果是否和预期一致。
 * @author Mask
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@ActiveProfiles("prod")
public class DemoBeanInterationTests {
	@Autowired
	private TestBean testBean;
	
	@Test
	public void prodBeanShouldInject(){
		String expected = "from production profile";
		String actual = testBean.getContent();
		Assert.assertEquals(expected, actual);
	}
}

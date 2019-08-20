package com.alienvault;

import com.alienvault.service.GitHubService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GithubissuesApplicationTests {

	@Autowired
	GitHubService service;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testService(){
		service.callGetIssues();
	}

}

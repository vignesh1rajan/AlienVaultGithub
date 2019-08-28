package com.alienvault;

import com.alienvault.client.data.Issue;
import com.alienvault.service.GitHubService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

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
		service.callGetIssues(Arrays.asList("octocat/Hello-World"));
	}


	@Test
	public void testDateParser() throws ParseException {
		Issue issue = new Issue();
		issue.setCreated_at("2019-06-26");
		Date format = new SimpleDateFormat("yyyy-MM-dd").parse(issue.getCreated_at());
		System.out.println(format);
		System.out.println(issue.getCreated_atDate());
	}

}

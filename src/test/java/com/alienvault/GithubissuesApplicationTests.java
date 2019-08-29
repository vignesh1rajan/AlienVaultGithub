package com.alienvault;

import com.alienvault.client.data.Issue;
import com.alienvault.ro.IssueRO;
import com.alienvault.service.GitHubService;
import org.junit.Assert;
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
		IssueRO issueRO = service.callGetIssues(Arrays.asList("octocat/Hello-World", "octocat/Hello-World"));
		Assert.assertNotNull(issueRO);
		Assert.assertNotNull(issueRO.getTop_day());
		Assert.assertNotNull(issueRO.getIssues());

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

package com.example.baseball;

import com.example.baseball.model.GameInfo;
import com.example.baseball.util.BaseBallUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseballGameTests {
	BaseBallMethod baseBallMethod;
	BaseBallUtil baseBallUtil;

	@Test
	public void contextLoads() {
		GameInfo gameInfo;
	//	baseBallUtil.numberFormValidate();
	}

}

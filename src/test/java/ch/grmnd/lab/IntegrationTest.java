package ch.grmnd.lab;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = IntegrationTestConfig.class)
public class IntegrationTest {

    @Autowired
    TestService testService;

    @Test
    public void testSendAndReceive() throws Exception {

        final Object testVal = UUID.randomUUID().toString();
        final Object res = testService.process(new TestEntity(testVal));
        Assert.assertEquals(testVal, res);

    }
}

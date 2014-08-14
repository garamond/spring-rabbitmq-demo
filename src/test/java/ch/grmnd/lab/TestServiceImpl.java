package ch.grmnd.lab;

class TestServiceImpl implements TestService {

    @Override
    public String process(TestEntity testEntity) {
        return testEntity.getValue();
    }

}

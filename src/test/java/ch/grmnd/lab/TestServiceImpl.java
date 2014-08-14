package ch.grmnd.lab;

class TestServiceImpl implements TestService {

    @Override
    public Object process(TestEntity testEntity) {
        return testEntity.getValue();
    }

}

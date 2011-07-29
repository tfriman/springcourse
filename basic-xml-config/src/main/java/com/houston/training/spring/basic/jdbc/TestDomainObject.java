package com.houston.training.spring.basic.jdbc;

/**
 * Dummy domain object.
 *
 * @author <a href="mailto:timo.friman@houston-inc.com">Timo Friman</a>
 */
public class TestDomainObject {
    private long id;

    private String name;

    public TestDomainObject(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestDomainObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

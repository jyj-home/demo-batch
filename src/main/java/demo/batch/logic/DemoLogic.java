package demo.batch.logic;

import demo.batch.gen.entity.Person;
import demo.batch.gen.entity.PersonExample;
import demo.batch.gen.entity.PersonExample.Criteria;
import demo.batch.gen.repository.PersonMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** xxxxxxxxxxxx. */
@Component
public class DemoLogic {
  @Autowired
  PersonMapper personMapper;

  /**
   * @param personKey
   * @return
   */
  public List<Person> getInfo(Person person) {
    PersonExample personExample = new PersonExample();
    Criteria criteria = personExample.createCriteria();
    if (person.getPersonId() != null) {
      criteria.andPersonIdEqualTo(person.getPersonId());
    }
    criteria.andNameLike(person.getName());

    if (person.getAge() != null) {
      criteria.andAgeGreaterThan(person.getAge());
    }

    return this.personMapper.selectByExample(personExample);
  }

  public int createInfo(Person person) {
    return this.personMapper.insert(person);
  }
}

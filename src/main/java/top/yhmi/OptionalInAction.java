package top.yhmi;

import java.util.Optional;

/**
 * ClassName: OptionalInAction <br/>
 * Description: <br/>
 * date: 2019/5/18 17:13<br/>
 *
 * @author Administrator<br />
 * @Date: Created in 17:13 2019/5/18
 * @Modified By:
 */
public class OptionalInAction {
    public static void main(String[] args) {
        System.out.println(getInsuranceNameByOptional(null));
        Optional.ofNullable(getInsuranceNameByOptional(null)).ifPresent(System.out::println);
    }
    private static String getInsuranceNameByOptional(Person person){
        return Optional.ofNullable(person)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName).orElse("unknown");
    }
}

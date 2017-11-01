package com.collect.guava.filter;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.List;

/**
 * Created by lifana on 2017/5/26.
 */
public class MainTest {
    public static void main(String[] args) {
        try {
            /*过滤器*/
            List list = Lists.newArrayList(1, 2, 3, 4, 20);
            Joiner join = Joiner.on(",").skipNulls();
            Collection<Integer> filterCollection =
                    Collections2.filter(list, new Predicate<Integer>() {
                        @Override
                        public boolean apply(Integer input) {
                            return input >= 0;
                        }
                    });

            System.out.println(join.join(filterCollection));

//            filterCollection.add(4); /*异常出现*/

            System.out.println("===========================================================");

            /*转换器*/
            Collection<String>  formatCollection =
                    Collections2.transform(list, new Function<Integer, String>(){
                        @Override
                        public String apply(Integer input) {
                            System.out.println("stest");
                            return new DecimalFormat("#,###").format(input);
                        }} );

            System.out.println(join.join(formatCollection));
        } catch(Exception e){
            System.out.println(e);
        }
    }
}

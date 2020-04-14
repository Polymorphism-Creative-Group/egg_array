/*
 * Copyright 2020 Jonathan Chang, Chun-yien <ccy@musicapoetica.org>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tech.metacontext.tutorial.ete.article;

import java.util.List;
import static java.util.function.Predicate.not;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.Getter;
import tech.metacontext.tutorial.ete.ex.CookingRottenEggException;
import tech.metacontext.tutorial.ete.ex.EggNotCookedException;
import tech.metacontext.tutorial.ete.ex.EggStillWrappedException;

/**
 *
 * @author Jonathan Chang, Chun-yien <ccy@musicapoetica.org>
 */
public class ArticleMain {

    public static void main(String[] args) {

        List<Egg> eggRack;
        eggRack = Stream.generate(Egg::new).limit(100).collect(Collectors.toList());

        // eggRack.forEach(Egg::eat); // EggStillWrappedException
        // ---
        // eggRack.forEach(Egg::unwrap);
        // eggRack.forEach(Egg::cook); // CookingRottenEggException
        // eggRack.forEach(Egg::eat);
        
        eggRack.stream()
                .peek(Egg::unwrap)
                .filter(not(Egg::isRotten))
                .peek(Egg::cook)
                .forEach(Egg::eat);
    }
}

@Getter
class Egg {

    boolean wrapped;
    boolean rotten;
    boolean cooked;

    Egg() {
        this.wrapped = true;
        this.rotten = Math.random() < 0.2;  // 有20%的機率會是臭蛋
        this.cooked = false;
    }

    void unwrap() {
        this.wrapped = false;
        System.out.print("Unwrapped! ");
    }

    void cook() {
        if (this.rotten) throw new CookingRottenEggException(); //「蛋臭了是要怎麼煮」例外
        this.cooked = true;
        System.out.print("Cooked! ");
    }

    void eat() {
        if (wrapped) throw new EggStillWrappedException();
        if (!cooked) throw new EggNotCookedException();
        System.out.print("Yammi! ");
    }
}

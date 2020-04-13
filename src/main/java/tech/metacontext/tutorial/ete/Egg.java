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
package tech.metacontext.tutorial.ete;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tech.metacontext.tutorial.ete.ex.CookingRottenEggException;
import tech.metacontext.tutorial.ete.ex.EggBurntException;
import tech.metacontext.tutorial.ete.ex.EggNotCookedException;
import tech.metacontext.tutorial.ete.ex.EggStillWrappedException;

/**
 *
 * @author Jonathan Chang, Chun-yien <ccy@musicapoetica.org>
 */
@Getter @Setter @ToString
public class Egg {

    boolean wrapped;
    boolean rotten;
    boolean cooked;

    public Egg() {
        this.wrapped = true;
        this.rotten = Math.random() < 0.1;
        this.cooked = false;
    }

    public void unwrap() {
        if (wrapped) {
            this.wrapped = false;
            System.out.print("Unwrapped. ");
        } else {
            System.out.println("Already unwrapped.");
        }
    }

    public void cook() {
        if (wrapped) throw new EggStillWrappedException();
        if (rotten) throw new CookingRottenEggException();
        if (cooked) throw new EggBurntException();
        this.cooked = true;
        System.out.print("Cooked! ");
    }

    public void eat() {
        if (wrapped) throw new EggStillWrappedException();
        if (!cooked) throw new EggNotCookedException(
                    this.rotten
                            ? "The egg is rotten!!!"
                            : "The egg is not cooked yet.");
        System.out.print("Yammi! ");
    }
}

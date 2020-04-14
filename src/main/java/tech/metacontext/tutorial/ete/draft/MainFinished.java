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
package tech.metacontext.tutorial.ete.draft;

import static java.util.function.Predicate.not;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A Java Tutorial for <br>
 * 1. List, <br>
 * 2. Class and Status, <br>
 * 3. Use of Exceptions, and <br>
 * 4. Stream Interface.
 *
 * @author Jonathan Chang, Chun-yien <ccy@musicapoetica.org>
 */
public class MainFinished {

    public static void main(String[] args) {

        var number = 100;
        // List<Egg> eggRack
        var eggRack = Stream.generate(Egg::new)
                .limit(number)
                .collect(Collectors.toList());
        System.out.println("\nWe have " + eggRack.size() + " eggs!!\n");
        // To see what we've got.
        // eggRack.forEach(System.out::println);
        // Can we eat them?
        System.out.println("\nCan we eat them?\n");
        try {
            eggRack.forEach(Egg::eat);
        } catch (Exception ex) {
            System.out.println("\nNo we can't because of " + ex.getClass().getSimpleName());
        }
        // So we have to unwrap them first.
        System.out.println("\nSo we have to unwrap them first.\n");
        eggRack.forEach(Egg::unwrap);
        // Can we eat them now?
        System.out.println("\nCan we eat them now?");
        try {
            eggRack.forEach(Egg::eat);
        } catch (Exception ex) {
            System.out.println("\nNo we can't because of " + ex.getClass().getSimpleName());
        }
        // So we just cook them.
        try {
            eggRack.forEach(Egg::cook);
        } catch (Exception ex) {
            System.out.println("\nOh no! " + ex.getClass().getSimpleName());
        }
        // We have to filter out the rotten ones.
        System.out.println("\nWe have to filter out the rotten ones then cook.\n");
        eggRack.stream().filter(not(Egg::isRotten)).filter(not(Egg::isCooked)).forEach(Egg::cook);
        // Can we eat them now?
        System.out.println("\nCan we eat them now?\n");
        try {
            eggRack.stream().forEach(Egg::eat);
        } catch (Exception ex) {
            System.out.println("\nOh no! We can't eat those rotten " + ex.getClass().getSimpleName());
        }
        // So if we filter them out, we eat now!
        System.out.println("\nSo if we filter them out, we eat now!\n");
        eggRack.stream().filter(Egg::isCooked).forEach(Egg::eat);

    }
}

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
package tech.metacontext.tutorial.ete.ex;

/**
 *
 * @author Jonathan Chang, Chun-yien <ccy@musicapoetica.org>
 */
public class EggNotCookedException extends RuntimeException {

    /**
     * Creates a new instance of <code>EggNotCookedException</code> without
     * detail message.
     */
    public EggNotCookedException() {
    }

    /**
     * Constructs an instance of <code>EggNotCookedException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public EggNotCookedException(String msg) {
        super(msg);
    }
}

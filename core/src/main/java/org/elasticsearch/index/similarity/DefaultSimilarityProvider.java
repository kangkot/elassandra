/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.index.similarity;

import org.apache.lucene.search.similarities.DefaultSimilarity;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.assistedinject.Assisted;
import org.elasticsearch.common.settings.Settings;

/**
 * {@link SimilarityProvider} for {@link DefaultSimilarity}.
 * <p>
 * Configuration options available:
 * <ul>
 *     <li>discount_overlaps</li>
 * </ul>
 * @see DefaultSimilarity For more information about configuration
 */
public class DefaultSimilarityProvider extends AbstractSimilarityProvider {

    private final DefaultSimilarity similarity = new DefaultSimilarity();

    @Inject
    public DefaultSimilarityProvider(@Assisted String name, @Assisted Settings settings) {
        super(name);
        boolean discountOverlaps = settings.getAsBoolean("discount_overlaps", true);
        this.similarity.setDiscountOverlaps(discountOverlaps);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DefaultSimilarity get() {
        return similarity;
    }
}

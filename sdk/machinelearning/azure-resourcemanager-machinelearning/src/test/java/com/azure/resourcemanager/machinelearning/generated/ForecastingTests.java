// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.machinelearning.models.BlockedTransformers;
import com.azure.resourcemanager.machinelearning.models.FeatureLags;
import com.azure.resourcemanager.machinelearning.models.FeaturizationMode;
import com.azure.resourcemanager.machinelearning.models.ForecastHorizon;
import com.azure.resourcemanager.machinelearning.models.Forecasting;
import com.azure.resourcemanager.machinelearning.models.ForecastingModels;
import com.azure.resourcemanager.machinelearning.models.ForecastingPrimaryMetrics;
import com.azure.resourcemanager.machinelearning.models.ForecastingSettings;
import com.azure.resourcemanager.machinelearning.models.ForecastingTrainingSettings;
import com.azure.resourcemanager.machinelearning.models.InputDeliveryMode;
import com.azure.resourcemanager.machinelearning.models.LogVerbosity;
import com.azure.resourcemanager.machinelearning.models.MLTableJobInput;
import com.azure.resourcemanager.machinelearning.models.NCrossValidations;
import com.azure.resourcemanager.machinelearning.models.Seasonality;
import com.azure.resourcemanager.machinelearning.models.ShortSeriesHandlingConfiguration;
import com.azure.resourcemanager.machinelearning.models.StackEnsembleSettings;
import com.azure.resourcemanager.machinelearning.models.StackMetaLearnerType;
import com.azure.resourcemanager.machinelearning.models.TableVerticalFeaturizationSettings;
import com.azure.resourcemanager.machinelearning.models.TableVerticalLimitSettings;
import com.azure.resourcemanager.machinelearning.models.TargetAggregationFunction;
import com.azure.resourcemanager.machinelearning.models.TargetLags;
import com.azure.resourcemanager.machinelearning.models.TargetRollingWindowSize;
import com.azure.resourcemanager.machinelearning.models.UseStl;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class ForecastingTests {
    @Test
    public void testDeserialize() {
        Forecasting model =
            BinaryData
                .fromString(
                    "{\"taskType\":\"Forecasting\",\"forecastingSettings\":{\"countryOrRegionForHolidays\":\"zxmdew\",\"cvStepSize\":1373177035,\"featureLags\":\"Auto\",\"forecastHorizon\":{\"mode\":\"ForecastHorizon\"},\"frequency\":\"lbjazejww\",\"seasonality\":{\"mode\":\"Seasonality\"},\"shortSeriesHandlingConfig\":\"Pad\",\"targetAggregateFunction\":\"Min\",\"targetLags\":{\"mode\":\"TargetLags\"},\"targetRollingWindowSize\":{\"mode\":\"TargetRollingWindowSize\"},\"timeColumnName\":\"brnnhjxsqw\",\"timeSeriesIdColumnNames\":[\"kbiwetpozyc\",\"qiqyhgfsetzlexbs\"],\"useStl\":\"None\"},\"primaryMetric\":\"R2Score\",\"trainingSettings\":{\"allowedTrainingAlgorithms\":[\"GradientBoosting\",\"SeasonalNaive\"],\"blockedTrainingAlgorithms\":[\"RandomForest\",\"Arimax\",\"Arimax\",\"Prophet\"],\"enableDnnTraining\":true,\"enableModelExplainability\":false,\"enableOnnxCompatibleModels\":true,\"enableStackEnsemble\":false,\"enableVoteEnsemble\":false,\"ensembleModelDownloadTimeout\":\"PT225H4M15S\",\"stackEnsembleSettings\":{\"stackMetaLearnerKWargs\":\"datalpkpbafvafhl\",\"stackMetaLearnerTrainPercentage\":11.719010334787338,\"stackMetaLearnerType\":\"ElasticNet\"}},\"cvSplitColumnNames\":[\"xrhyzdfwrsofplt\"],\"featurizationSettings\":{\"blockedTransformers\":[\"WordEmbedding\",\"TextTargetEncoder\",\"TfIdf\",\"TfIdf\"],\"columnNameAndTypes\":{\"npq\":\"fnrac\",\"uuj\":\"g\"},\"enableDnnFeaturization\":false,\"mode\":\"Auto\",\"transformerParams\":{\"igrb\":[],\"xsjybvitvqk\":[],\"az\":[]},\"datasetLanguage\":\"mtggmu\"},\"limitSettings\":{\"enableEarlyTermination\":false,\"exitScore\":73.03774094829895,\"maxConcurrentTrials\":1401154430,\"maxCoresPerTrial\":737761166,\"maxTrials\":273920655,\"timeout\":\"PT29H11M39S\",\"trialTimeout\":\"PT238H15M11S\"},\"nCrossValidations\":{\"mode\":\"NCrossValidations\"},\"testData\":{\"jobInputType\":\"mltable\",\"mode\":\"ReadOnlyMount\",\"uri\":\"voaiknaqlnuw\",\"description\":\"uyxlykwphvxzcw\"},\"testDataSize\":14.530784309792832,\"validationData\":{\"jobInputType\":\"mltable\",\"mode\":\"EvalDownload\",\"uri\":\"lkexaonwivkcqh\",\"description\":\"hxknlccrmmkyupi\"},\"validationDataSize\":89.69731810693186,\"weightColumnName\":\"jfkakfqfrke\",\"logVerbosity\":\"Error\",\"targetColumnName\":\"dudxjascowvfdjk\",\"trainingData\":{\"jobInputType\":\"mltable\",\"mode\":\"Direct\",\"uri\":\"phlkksnm\",\"description\":\"vyfijdkzuqnw\"}}")
                .toObject(Forecasting.class);
        Assertions.assertEquals(LogVerbosity.ERROR, model.logVerbosity());
        Assertions.assertEquals("dudxjascowvfdjk", model.targetColumnName());
        Assertions.assertEquals("vyfijdkzuqnw", model.trainingData().description());
        Assertions.assertEquals(InputDeliveryMode.DIRECT, model.trainingData().mode());
        Assertions.assertEquals("phlkksnm", model.trainingData().uri());
        Assertions.assertEquals("zxmdew", model.forecastingSettings().countryOrRegionForHolidays());
        Assertions.assertEquals(1373177035, model.forecastingSettings().cvStepSize());
        Assertions.assertEquals(FeatureLags.AUTO, model.forecastingSettings().featureLags());
        Assertions.assertEquals("lbjazejww", model.forecastingSettings().frequency());
        Assertions
            .assertEquals(
                ShortSeriesHandlingConfiguration.PAD, model.forecastingSettings().shortSeriesHandlingConfig());
        Assertions.assertEquals(TargetAggregationFunction.MIN, model.forecastingSettings().targetAggregateFunction());
        Assertions.assertEquals("brnnhjxsqw", model.forecastingSettings().timeColumnName());
        Assertions.assertEquals("kbiwetpozyc", model.forecastingSettings().timeSeriesIdColumnNames().get(0));
        Assertions.assertEquals(UseStl.NONE, model.forecastingSettings().useStl());
        Assertions.assertEquals(ForecastingPrimaryMetrics.R2SCORE, model.primaryMetric());
        Assertions.assertEquals(true, model.trainingSettings().enableDnnTraining());
        Assertions.assertEquals(false, model.trainingSettings().enableModelExplainability());
        Assertions.assertEquals(true, model.trainingSettings().enableOnnxCompatibleModels());
        Assertions.assertEquals(false, model.trainingSettings().enableStackEnsemble());
        Assertions.assertEquals(false, model.trainingSettings().enableVoteEnsemble());
        Assertions.assertEquals(Duration.parse("PT225H4M15S"), model.trainingSettings().ensembleModelDownloadTimeout());
        Assertions
            .assertEquals(
                11.719010334787338D,
                model.trainingSettings().stackEnsembleSettings().stackMetaLearnerTrainPercentage());
        Assertions
            .assertEquals(
                StackMetaLearnerType.ELASTIC_NET,
                model.trainingSettings().stackEnsembleSettings().stackMetaLearnerType());
        Assertions
            .assertEquals(
                ForecastingModels.GRADIENT_BOOSTING, model.trainingSettings().allowedTrainingAlgorithms().get(0));
        Assertions
            .assertEquals(ForecastingModels.RANDOM_FOREST, model.trainingSettings().blockedTrainingAlgorithms().get(0));
        Assertions.assertEquals("xrhyzdfwrsofplt", model.cvSplitColumnNames().get(0));
        Assertions.assertEquals("mtggmu", model.featurizationSettings().datasetLanguage());
        Assertions
            .assertEquals(
                BlockedTransformers.WORD_EMBEDDING, model.featurizationSettings().blockedTransformers().get(0));
        Assertions.assertEquals("fnrac", model.featurizationSettings().columnNameAndTypes().get("npq"));
        Assertions.assertEquals(false, model.featurizationSettings().enableDnnFeaturization());
        Assertions.assertEquals(FeaturizationMode.AUTO, model.featurizationSettings().mode());
        Assertions.assertEquals(false, model.limitSettings().enableEarlyTermination());
        Assertions.assertEquals(73.03774094829895D, model.limitSettings().exitScore());
        Assertions.assertEquals(1401154430, model.limitSettings().maxConcurrentTrials());
        Assertions.assertEquals(737761166, model.limitSettings().maxCoresPerTrial());
        Assertions.assertEquals(273920655, model.limitSettings().maxTrials());
        Assertions.assertEquals(Duration.parse("PT29H11M39S"), model.limitSettings().timeout());
        Assertions.assertEquals(Duration.parse("PT238H15M11S"), model.limitSettings().trialTimeout());
        Assertions.assertEquals("uyxlykwphvxzcw", model.testData().description());
        Assertions.assertEquals(InputDeliveryMode.READ_ONLY_MOUNT, model.testData().mode());
        Assertions.assertEquals("voaiknaqlnuw", model.testData().uri());
        Assertions.assertEquals(14.530784309792832D, model.testDataSize());
        Assertions.assertEquals("hxknlccrmmkyupi", model.validationData().description());
        Assertions.assertEquals(InputDeliveryMode.EVAL_DOWNLOAD, model.validationData().mode());
        Assertions.assertEquals("lkexaonwivkcqh", model.validationData().uri());
        Assertions.assertEquals(89.69731810693186D, model.validationDataSize());
        Assertions.assertEquals("jfkakfqfrke", model.weightColumnName());
    }

    @Test
    public void testSerialize() {
        Forecasting model =
            new Forecasting()
                .withLogVerbosity(LogVerbosity.ERROR)
                .withTargetColumnName("dudxjascowvfdjk")
                .withTrainingData(
                    new MLTableJobInput()
                        .withDescription("vyfijdkzuqnw")
                        .withMode(InputDeliveryMode.DIRECT)
                        .withUri("phlkksnm"))
                .withForecastingSettings(
                    new ForecastingSettings()
                        .withCountryOrRegionForHolidays("zxmdew")
                        .withCvStepSize(1373177035)
                        .withFeatureLags(FeatureLags.AUTO)
                        .withForecastHorizon(new ForecastHorizon())
                        .withFrequency("lbjazejww")
                        .withSeasonality(new Seasonality())
                        .withShortSeriesHandlingConfig(ShortSeriesHandlingConfiguration.PAD)
                        .withTargetAggregateFunction(TargetAggregationFunction.MIN)
                        .withTargetLags(new TargetLags())
                        .withTargetRollingWindowSize(new TargetRollingWindowSize())
                        .withTimeColumnName("brnnhjxsqw")
                        .withTimeSeriesIdColumnNames(Arrays.asList("kbiwetpozyc", "qiqyhgfsetzlexbs"))
                        .withUseStl(UseStl.NONE))
                .withPrimaryMetric(ForecastingPrimaryMetrics.R2SCORE)
                .withTrainingSettings(
                    new ForecastingTrainingSettings()
                        .withEnableDnnTraining(true)
                        .withEnableModelExplainability(false)
                        .withEnableOnnxCompatibleModels(true)
                        .withEnableStackEnsemble(false)
                        .withEnableVoteEnsemble(false)
                        .withEnsembleModelDownloadTimeout(Duration.parse("PT225H4M15S"))
                        .withStackEnsembleSettings(
                            new StackEnsembleSettings()
                                .withStackMetaLearnerKWargs("datalpkpbafvafhl")
                                .withStackMetaLearnerTrainPercentage(11.719010334787338D)
                                .withStackMetaLearnerType(StackMetaLearnerType.ELASTIC_NET))
                        .withAllowedTrainingAlgorithms(
                            Arrays.asList(ForecastingModels.GRADIENT_BOOSTING, ForecastingModels.SEASONAL_NAIVE))
                        .withBlockedTrainingAlgorithms(
                            Arrays
                                .asList(
                                    ForecastingModels.RANDOM_FOREST,
                                    ForecastingModels.ARIMAX,
                                    ForecastingModels.ARIMAX,
                                    ForecastingModels.PROPHET)))
                .withCvSplitColumnNames(Arrays.asList("xrhyzdfwrsofplt"))
                .withFeaturizationSettings(
                    new TableVerticalFeaturizationSettings()
                        .withDatasetLanguage("mtggmu")
                        .withBlockedTransformers(
                            Arrays
                                .asList(
                                    BlockedTransformers.WORD_EMBEDDING,
                                    BlockedTransformers.TEXT_TARGET_ENCODER,
                                    BlockedTransformers.TF_IDF,
                                    BlockedTransformers.TF_IDF))
                        .withColumnNameAndTypes(mapOf("npq", "fnrac", "uuj", "g"))
                        .withEnableDnnFeaturization(false)
                        .withMode(FeaturizationMode.AUTO)
                        .withTransformerParams(
                            mapOf("igrb", Arrays.asList(), "xsjybvitvqk", Arrays.asList(), "az", Arrays.asList())))
                .withLimitSettings(
                    new TableVerticalLimitSettings()
                        .withEnableEarlyTermination(false)
                        .withExitScore(73.03774094829895D)
                        .withMaxConcurrentTrials(1401154430)
                        .withMaxCoresPerTrial(737761166)
                        .withMaxTrials(273920655)
                        .withTimeout(Duration.parse("PT29H11M39S"))
                        .withTrialTimeout(Duration.parse("PT238H15M11S")))
                .withNCrossValidations(new NCrossValidations())
                .withTestData(
                    new MLTableJobInput()
                        .withDescription("uyxlykwphvxzcw")
                        .withMode(InputDeliveryMode.READ_ONLY_MOUNT)
                        .withUri("voaiknaqlnuw"))
                .withTestDataSize(14.530784309792832D)
                .withValidationData(
                    new MLTableJobInput()
                        .withDescription("hxknlccrmmkyupi")
                        .withMode(InputDeliveryMode.EVAL_DOWNLOAD)
                        .withUri("lkexaonwivkcqh"))
                .withValidationDataSize(89.69731810693186D)
                .withWeightColumnName("jfkakfqfrke");
        model = BinaryData.fromObject(model).toObject(Forecasting.class);
        Assertions.assertEquals(LogVerbosity.ERROR, model.logVerbosity());
        Assertions.assertEquals("dudxjascowvfdjk", model.targetColumnName());
        Assertions.assertEquals("vyfijdkzuqnw", model.trainingData().description());
        Assertions.assertEquals(InputDeliveryMode.DIRECT, model.trainingData().mode());
        Assertions.assertEquals("phlkksnm", model.trainingData().uri());
        Assertions.assertEquals("zxmdew", model.forecastingSettings().countryOrRegionForHolidays());
        Assertions.assertEquals(1373177035, model.forecastingSettings().cvStepSize());
        Assertions.assertEquals(FeatureLags.AUTO, model.forecastingSettings().featureLags());
        Assertions.assertEquals("lbjazejww", model.forecastingSettings().frequency());
        Assertions
            .assertEquals(
                ShortSeriesHandlingConfiguration.PAD, model.forecastingSettings().shortSeriesHandlingConfig());
        Assertions.assertEquals(TargetAggregationFunction.MIN, model.forecastingSettings().targetAggregateFunction());
        Assertions.assertEquals("brnnhjxsqw", model.forecastingSettings().timeColumnName());
        Assertions.assertEquals("kbiwetpozyc", model.forecastingSettings().timeSeriesIdColumnNames().get(0));
        Assertions.assertEquals(UseStl.NONE, model.forecastingSettings().useStl());
        Assertions.assertEquals(ForecastingPrimaryMetrics.R2SCORE, model.primaryMetric());
        Assertions.assertEquals(true, model.trainingSettings().enableDnnTraining());
        Assertions.assertEquals(false, model.trainingSettings().enableModelExplainability());
        Assertions.assertEquals(true, model.trainingSettings().enableOnnxCompatibleModels());
        Assertions.assertEquals(false, model.trainingSettings().enableStackEnsemble());
        Assertions.assertEquals(false, model.trainingSettings().enableVoteEnsemble());
        Assertions.assertEquals(Duration.parse("PT225H4M15S"), model.trainingSettings().ensembleModelDownloadTimeout());
        Assertions
            .assertEquals(
                11.719010334787338D,
                model.trainingSettings().stackEnsembleSettings().stackMetaLearnerTrainPercentage());
        Assertions
            .assertEquals(
                StackMetaLearnerType.ELASTIC_NET,
                model.trainingSettings().stackEnsembleSettings().stackMetaLearnerType());
        Assertions
            .assertEquals(
                ForecastingModels.GRADIENT_BOOSTING, model.trainingSettings().allowedTrainingAlgorithms().get(0));
        Assertions
            .assertEquals(ForecastingModels.RANDOM_FOREST, model.trainingSettings().blockedTrainingAlgorithms().get(0));
        Assertions.assertEquals("xrhyzdfwrsofplt", model.cvSplitColumnNames().get(0));
        Assertions.assertEquals("mtggmu", model.featurizationSettings().datasetLanguage());
        Assertions
            .assertEquals(
                BlockedTransformers.WORD_EMBEDDING, model.featurizationSettings().blockedTransformers().get(0));
        Assertions.assertEquals("fnrac", model.featurizationSettings().columnNameAndTypes().get("npq"));
        Assertions.assertEquals(false, model.featurizationSettings().enableDnnFeaturization());
        Assertions.assertEquals(FeaturizationMode.AUTO, model.featurizationSettings().mode());
        Assertions.assertEquals(false, model.limitSettings().enableEarlyTermination());
        Assertions.assertEquals(73.03774094829895D, model.limitSettings().exitScore());
        Assertions.assertEquals(1401154430, model.limitSettings().maxConcurrentTrials());
        Assertions.assertEquals(737761166, model.limitSettings().maxCoresPerTrial());
        Assertions.assertEquals(273920655, model.limitSettings().maxTrials());
        Assertions.assertEquals(Duration.parse("PT29H11M39S"), model.limitSettings().timeout());
        Assertions.assertEquals(Duration.parse("PT238H15M11S"), model.limitSettings().trialTimeout());
        Assertions.assertEquals("uyxlykwphvxzcw", model.testData().description());
        Assertions.assertEquals(InputDeliveryMode.READ_ONLY_MOUNT, model.testData().mode());
        Assertions.assertEquals("voaiknaqlnuw", model.testData().uri());
        Assertions.assertEquals(14.530784309792832D, model.testDataSize());
        Assertions.assertEquals("hxknlccrmmkyupi", model.validationData().description());
        Assertions.assertEquals(InputDeliveryMode.EVAL_DOWNLOAD, model.validationData().mode());
        Assertions.assertEquals("lkexaonwivkcqh", model.validationData().uri());
        Assertions.assertEquals(89.69731810693186D, model.validationDataSize());
        Assertions.assertEquals("jfkakfqfrke", model.weightColumnName());
    }

    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}

package by.bulba.contour.map.common.provider

import android.content.Context
import androidx.annotation.StringRes
import by.bulba.contour.map.R
import by.bulba.contour.map.data.*
import com.google.android.gms.maps.model.LatLng

class StubTaskDescriptionProvider(
    private val context: Context
) : TaskDescriptionProvider<TaskDescription> {

    companion object {
        private val minZoom = 5.2f
        private val maxZoom = 6.5f
        private val defaultZomm = 5.2f
        private val countryCenter = LatLng(53.49036868765079, 27.64071609824896)

        private val regMinZoom = 5.2f
        private val regMaxZoom = 6.5f
        private val regDefaultZomm = 5.2f
        private val regCountryCenter = LatLng(53.49036868765079, 27.64071609824896)

        private val brestObl = GeoObject(1001, "obl/by_brest.kml")
        private val vitebskObl = GeoObject(1002, "obl/by_vitebsk.kml")
        private val gomelObl = GeoObject(1003, "obl/by_gomel.kml")
        private val grodnoObl = GeoObject(1004, "obl/by_grodno.kml")
        private val minskObl = GeoObject(1005, "obl/by_minsk.kml")
        private val mogilevObl = GeoObject(1006, "obl/by_mogilev.kml")

        private val baranovichiReg = GeoObject(1, "reg/r_1_baranovichi.kml")
        private val berezaReg = GeoObject(2, "reg/r_2_bereza.kml")
        private val brestReg = GeoObject(3, "reg/r_3_brest.kml")
        private val drogichinReg = GeoObject(4, "reg/r_4_drogichin.kml")
        private val gancevichiReg = GeoObject(5, "reg/r_5_gancevichi.kml")
        private val ivanovoReg = GeoObject(6, "reg/r_6_ivanovo.kml")
        private val ivatsevichiReg = GeoObject(7, "reg/r_7_ivatsevichi.kml")
        private val kamenetsReg = GeoObject(8, "reg/r_8_kamenets.kml")
        private val kobrinReg = GeoObject(9, "reg/r_9_kobrin.kml")
        private val luninetsReg = GeoObject(10, "reg/r_10_luninets.kml")
        private val lyahovichiReg = GeoObject(11, "reg/r_11_lyahovichi.kml")
        private val maloritaReg = GeoObject(12, "reg/r_12_malorita.kml")
        private val pinskReg = GeoObject(13, "reg/r_13_pinsk.kml")
        private val pruzhanuReg = GeoObject(14, "reg/r_14_pruzhanu.kml")
        private val stolinReg = GeoObject(15, "reg/r_15_stolin.kml")
        private val zhabinkaReg = GeoObject(16, "reg/r_16_zhabinka.kml")
        private val oktyabrskiReg = GeoObject(17, "reg/r_17_oktyabrski.kml")
        private val brahinReg = GeoObject(18, "reg/r_18_brahin.kml")
        private val buda_koshelevoReg = GeoObject(19, "reg/r_19_buda-koshelevo.kml")
        private val checherskReg = GeoObject(20, "reg/r_20_chechersk.kml")
        private val dobrushReg = GeoObject(21, "reg/r_21_dobrush.kml")
        private val homyelReg = GeoObject(22, "reg/r_22_homyel.kml")
        private val kalinkovichiReg = GeoObject(23, "reg/r_23_kalinkovichi.kml")
        private val kormaReg = GeoObject(24, "reg/r_24_korma.kml")
        private val khoinikiReg = GeoObject(25, "reg/r_25_khoiniki.kml")
        private val loevReg = GeoObject(26, "reg/r_26_loev.kml")
        private val lelchitsuReg = GeoObject(27, "reg/r_27_lelchitsu.kml")
        private val mozyrReg = GeoObject(28, "reg/r_28_mozyr.kml")
        private val narovlyaReg = GeoObject(29, "reg/r_29_narovlya.kml")
        private val petrikovReg = GeoObject(30, "reg/r_30_petrikov.kml")
        private val rogachevReg = GeoObject(31, "reg/r_31_rogachev.kml")
        private val rechitsaReg = GeoObject(32, "reg/r_32_rechitsa.kml")
        private val svetlogorskReg = GeoObject(33, "reg/r_33_svetlogorsk.kml")
        private val vetkaReg = GeoObject(34, "reg/r_34_vetka.kml")
        private val elskReg = GeoObject(35, "reg/r_35_elsk.kml")
        private val zhlobinReg = GeoObject(36, "reg/r_36_zhlobin.kml")
        private val zhitkovichiReg = GeoObject(37, "reg/r_37_zhitkovichi.kml")
        private val oshmyanuReg = GeoObject(38, "reg/r_38_oshmyanu.kml")
        private val ostrovetsReg = GeoObject(39, "reg/r_39_ostrovets.kml")
        private val berestovitsaReg = GeoObject(40, "reg/r_40_berestovitsa.kml")
        private val dyatlovoReg = GeoObject(41, "reg/r_41_dyatlovo.kml")
        private val hrodnaReg = GeoObject(42, "reg/r_42_hrodna.kml")
        private val ivyeReg = GeoObject(43, "reg/r_43_ivye.kml")
        private val korelichiReg = GeoObject(44, "reg/r_44_korelichi.kml")
        private val lidaReg = GeoObject(45, "reg/r_45_lida.kml")
        private val mostuReg = GeoObject(46, "reg/r_46_mostu.kml")
        private val novogrudokReg = GeoObject(47, "reg/r_47_novogrudok.kml")
        private val svislochReg = GeoObject(48, "reg/r_48_svisloch.kml")
        private val shchuchinReg = GeoObject(49, "reg/r_49_shchuchin.kml")
        private val slonimReg = GeoObject(50, "reg/r_50_slonim.kml")
        private val smorgonReg = GeoObject(51, "reg/r_51_smorgon.kml")
        private val volkovyskReg = GeoObject(52, "reg/r_52_volkovysk.kml")
        private val voronovoReg = GeoObject(53, "reg/r_53_voronovo.kml")
        private val zelvaReg = GeoObject(54, "reg/r_54_zelva.kml")
        private val osipovichiReg = GeoObject(55, "reg/r_55_osipovichi.kml")
        private val bobruyskReg = GeoObject(56, "reg/r_56_bobruysk.kml")
        private val belynichiReg = GeoObject(57, "reg/r_57_belynichi.kml")
        private val byhovReg = GeoObject(58, "reg/r_58_byhov.kml")
        private val chausuReg = GeoObject(59, "reg/r_59_chausu.kml")
        private val cherikovReg = GeoObject(60, "reg/r_60_cherikov.kml")
        private val dribinReg = GeoObject(61, "reg/r_61_dribin.kml")
        private val gluskReg = GeoObject(62, "reg/r_62_glusk.kml")
        private val gorkiReg = GeoObject(63, "reg/r_63_gorki.kml")
        private val kostyukovichiReg = GeoObject(64, "reg/r_64_kostyukovichi.kml")
        private val hotimskReg = GeoObject(65, "reg/r_65_hotimsk.kml")
        private val kirovskReg = GeoObject(66, "reg/r_66_kirovsk.kml")
        private val klichevReg = GeoObject(67, "reg/r_67_klichev.kml")
        private val klimovichiReg = GeoObject(68, "reg/r_68_klimovichi.kml")
        private val krasnopolyeReg = GeoObject(69, "reg/r_69_krasnopolye.kml")
        private val krugloyeReg = GeoObject(70, "reg/r_70_krugloye.kml")
        private val krichevReg = GeoObject(71, "reg/r_71_krichev.kml")
        private val mahilyowReg = GeoObject(72, "reg/r_72_mahilyow.kml")
        private val mstislavlReg = GeoObject(73, "reg/r_73_mstislavl.kml")
        private val shklovReg = GeoObject(74, "reg/r_74_shklov.kml")
        private val slavgorodReg = GeoObject(75, "reg/r_75_slavgorod.kml")
        private val borisovReg = GeoObject(76, "reg/r_76_borisov.kml")
        private val berezinoReg = GeoObject(77, "reg/r_77_berezino.kml")
        private val chervenReg = GeoObject(78, "reg/r_78_cherven.kml")
        private val dzerzhinskReg = GeoObject(79, "reg/r_79_dzerzhinsk.kml")
        private val kopylReg = GeoObject(80, "reg/r_80_kopyl.kml")
        private val kletskReg = GeoObject(81, "reg/r_81_kletsk.kml")
        private val krupkiReg = GeoObject(82, "reg/r_82_krupki.kml")
        private val logoyskReg = GeoObject(83, "reg/r_83_logoysk.kml")
        private val lyubanReg = GeoObject(84, "reg/r_84_lyuban.kml")
        private val molodechnoReg = GeoObject(85, "reg/r_85_molodechno.kml")
        private val minskReg = GeoObject(86, "reg/r_86_minsk.kml")
        private val myadelReg = GeoObject(87, "reg/r_87_myadel.kml")
        private val nesvizhReg = GeoObject(88, "reg/r_88_nesvizh.kml")
        private val puhovichiReg = GeoObject(89, "reg/r_89_puhovichi.kml")
        private val soligorskReg = GeoObject(90, "reg/r_90_soligorsk.kml")
        private val slutskReg = GeoObject(91, "reg/r_91_slutsk.kml")
        private val smolevichiReg = GeoObject(92, "reg/r_92_smolevichi.kml")
        private val starye_dorogiReg = GeoObject(93, "reg/r_93_starye dorogi.kml")
        private val stolbtsuReg = GeoObject(94, "reg/r_94_stolbtsu.kml")
        private val uzdaReg = GeoObject(95, "reg/r_95_uzda.kml")
        private val volozhinReg = GeoObject(96, "reg/r_96_volozhin.kml")
        private val vileykaReg = GeoObject(97, "reg/r_97_vileyka.kml")
        private val orshaReg = GeoObject(98, "reg/r_98_orsha.kml")
        private val braslavReg = GeoObject(99, "reg/r_99_braslav.kml")
        private val beshenkovichiReg = GeoObject(100, "reg/r_100_beshenkovichi.kml")
        private val chashnikiReg = GeoObject(101, "reg/r_101_chashniki.kml")
        private val dokshitsyReg = GeoObject(102, "reg/r_102_dokshitsy.kml")
        private val dubrovnoReg = GeoObject(103, "reg/r_103_dubrovno.kml")
        private val gorodokReg = GeoObject(104, "reg/r_104_gorodok.kml")
        private val glubokoyeReg = GeoObject(105, "reg/r_105_glubokoye.kml")
        private val lepelReg = GeoObject(106, "reg/r_106_lepel.kml")
        private val lioznoReg = GeoObject(107, "reg/r_107_liozno.kml")
        private val mioruReg = GeoObject(108, "reg/r_108_mioru.kml")
        private val postavuReg = GeoObject(109, "reg/r_109_postavu.kml")
        private val polotskReg = GeoObject(110, "reg/r_110_polotsk.kml")
        private val rossonuReg = GeoObject(111, "reg/r_111_rossonu.kml")
        private val sharkovshchinaReg = GeoObject(112, "reg/r_112_sharkovshchina.kml")
        private val shumilinoReg = GeoObject(113, "reg/r_113_shumilino.kml")
        private val sennoReg = GeoObject(114, "reg/r_114_senno.kml")
        private val tolochinReg = GeoObject(115, "reg/r_115_tolochin.kml")
        private val ushachiReg = GeoObject(116, "reg/r_116_ushachi.kml")
        private val vitsyebskReg = GeoObject(117, "reg/r_117_vitsyebsk.kml")
        private val verhnedvinskReg = GeoObject(118, "reg/r_118_verhnedvinsk.kml")
    }

    private val oblList = listOf(
        brestObl,
        vitebskObl,
        gomelObl,
        grodnoObl,
        minskObl,
        mogilevObl
    )

    override val taskDescriptions: List<TaskDescription>
        get() = listOf(
            oblGeoSelectorTaskDescription(
                oblGeoSelectorQuiz(
                    R.string.geo_selector_quiz_question_1,
                    vitebskObl
                )
            ),
            oblGeoSelectorTaskDescription(
                oblGeoSelectorQuiz(
                    R.string.geo_selector_quiz_question_2,
                    gomelObl
                )
            ),
            oblGeoSelectorTaskDescription(
                oblGeoSelectorQuiz(
                    R.string.geo_selector_quiz_question_3,
                    vitebskObl
                )
            ),
            oblGeoSelectorTaskDescription(
                oblGeoSelectorQuiz(
                    R.string.geo_selector_quiz_question_4,
                    minskObl
                )
            ),
            oblGeoSelectorTaskDescription(
                oblGeoSelectorQuiz(
                    R.string.geo_selector_quiz_question_5,
                    grodnoObl
                )
            ),
            oblGeoSelectorTaskDescription(
                oblGeoSelectorQuiz(
                    R.string.geo_selector_quiz_question_6,
                    gomelObl
                )
            ),
            oblGeoSelectorTaskDescription(
                oblGeoSelectorQuiz(
                    R.string.geo_selector_quiz_question_7,
                    mogilevObl
                )
            ),
            oblGeoSelectorTaskDescription(
                oblGeoSelectorQuiz(
                    R.string.geo_selector_quiz_question_8,
                    vitebskObl
                )
            ),
            oblGeoSelectorTaskDescription(
                oblGeoSelectorQuiz(
                    R.string.geo_selector_quiz_question_9,
                    vitebskObl
                )
            ),
            oblGeoSelectorTaskDescription(
                oblGeoSelectorQuiz(
                    R.string.geo_selector_quiz_question_10,
                    brestObl
                )
            ),

            // REGIONS
            regGeoSelectorTaskDescription(
                regGeoSelectorQuiz(
                    R.string.geo_selector_quiz_question_11,
                    listOf(checherskReg, ivanovoReg, mstislavlReg, klichevReg, dubrovnoReg, mioruReg),
                    mioruReg
                )
            ),
            regGeoSelectorTaskDescription(
                regGeoSelectorQuiz(
                    R.string.geo_selector_quiz_question_12,
                    listOf(kamenetsReg, brahinReg, verhnedvinskReg, rossonuReg, brestReg, hotimskReg),
                    hotimskReg
                )
            ),
            regGeoSelectorTaskDescription(
                regGeoSelectorQuiz(
                    R.string.geo_selector_quiz_question_13,
                    listOf(rogachevReg, cherikovReg, checherskReg, mozyrReg, sharkovshchinaReg, puhovichiReg),
                    puhovichiReg
                )
            ),
            regGeoSelectorTaskDescription(
                regGeoSelectorQuiz(
                    R.string.geo_selector_quiz_question_14,
                    listOf(minskReg, puhovichiReg, brestReg, berestovitsaReg, vitsyebskReg, polotskReg),
                    polotskReg
                )
            ),
            regGeoSelectorTaskDescription(
                regGeoSelectorQuiz(
                    R.string.geo_selector_quiz_question_15,
                    listOf(shchuchinReg, ostrovetsReg, ivyeReg, lidaReg, berestovitsaReg, voronovoReg),
                    voronovoReg
                )
            ),
            regGeoSelectorTaskDescription(
                regGeoSelectorQuiz(
                    R.string.geo_selector_quiz_question_16,
                    listOf(krugloyeReg, mostuReg, krasnopolyeReg, kamenetsReg, minskReg, khoinikiReg),
                    khoinikiReg
                )
            ),
            regGeoSelectorTaskDescription(
                regGeoSelectorQuiz(
                    R.string.geo_selector_quiz_question_17,
                    listOf(krupkiReg, luninetsReg, lelchitsuReg, elskReg, byhovReg, chashnikiReg),
                    chashnikiReg
                )
            ),
            regGeoSelectorTaskDescription(
                regGeoSelectorQuiz(
                    R.string.geo_selector_quiz_question_18,
                    listOf(minskReg, puhovichiReg, berezaReg, kobrinReg, klimovichiReg, korelichiReg),
                    korelichiReg
                )
            ),
            regGeoSelectorTaskDescription(
                regGeoSelectorQuiz(
                    R.string.geo_selector_quiz_question_19,
                    listOf(vileykaReg, mostuReg, oshmyanuReg, puhovichiReg, rechitsaReg, luninetsReg),
                    luninetsReg
                )
            ),
            regGeoSelectorTaskDescription(
                regGeoSelectorQuiz(
                    R.string.geo_selector_quiz_question_20,
                    listOf(buda_koshelevoReg, krupkiReg, luninetsReg, novogrudokReg, mahilyowReg, vileykaReg),
                    vileykaReg
                )
            ),
            regGeoSelectorTaskDescription(
                regGeoSelectorQuiz(
                    R.string.geo_selector_quiz_question_21,
                    listOf(starye_dorogiReg, kirovskReg, chashnikiReg, hotimskReg, ostrovetsReg, soligorskReg),
                    soligorskReg
                )
            )
        )

    private fun regGeoSelectorTaskDescription(task: Task) =
        GeoSelectorTaskDescription(task, TaskType.REG_GEO_SELECTOR_QUIZ)

    private fun oblGeoSelectorTaskDescription(task: Task) =
        GeoSelectorTaskDescription(task, TaskType.GEO_SELECTOR_QUIZ)

    private fun regGeoSelectorQuiz(@StringRes descriptionRes: Int, possibleAnswers: List<GeoObject>, answer: GeoObject) =
        GeoSelectorQuiz(
            getDescription(descriptionRes),
            regMinZoom,
            regMaxZoom,
            regDefaultZomm,
            regCountryCenter,
            possibleAnswers,
            answer
        )

    private fun oblGeoSelectorQuiz(@StringRes descriptionRes: Int, answer: GeoObject) =
        GeoSelectorQuiz(
            getDescription(descriptionRes),
            minZoom,
            maxZoom,
            defaultZomm,
            countryCenter,
            oblList,
            answer
        )

    private fun getDescription(@StringRes descriptionRes: Int) = context.getString(descriptionRes)

}

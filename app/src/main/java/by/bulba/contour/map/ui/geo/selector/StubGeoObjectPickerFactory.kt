package by.bulba.contour.map.ui.geo.selector

import android.content.Context
import by.bulba.contour.map.common.provider.FileGeoObjectPicker
import by.bulba.contour.map.common.provider.GeoObjectPicker
import by.bulba.contour.map.common.provider.GeoObjectPickerFactory
import by.bulba.contour.map.data.GeoObject

class StubGeoObjectPickerFactory(
    private val context: Context
) : GeoObjectPickerFactory {

    override fun create(): GeoObjectPicker {
        val map = linkedMapOf(
            Pair(GeoObject(1, "reg/r_1_baranovichi.kml"), "reg/p_1_baranovichi.txt"),
            Pair(GeoObject(2, "reg/r_2_bereza.kml"), "reg/p_2_bereza.txt"),
            Pair(GeoObject(3, "reg/r_3_brest.kml"), "reg/p_3_brest.txt"),
            Pair(GeoObject(4, "reg/r_4_drogichin.kml"), "reg/p_4_drogichin.txt"),
            Pair(GeoObject(5, "reg/r_5_gancevichi.kml"), "reg/p_5_gancevichi.txt"),
            Pair(GeoObject(6, "reg/r_6_ivanovo.kml"), "reg/p_6_ivanovo.txt"),
            Pair(GeoObject(7, "reg/r_7_ivatsevichi.kml"), "reg/p_7_ivatsevichi.txt"),
            Pair(GeoObject(8, "reg/r_8_kamenets.kml"), "reg/p_8_kamenets.txt"),
            Pair(GeoObject(9, "reg/r_9_kobrin.kml"), "reg/p_9_kobrin.txt"),
            Pair(GeoObject(10, "reg/r_10_luninets.kml"), "reg/p_10_luninets.txt"),
            Pair(GeoObject(11, "reg/r_11_lyahovichi.kml"), "reg/p_11_lyahovichi.txt"),
            Pair(GeoObject(12, "reg/r_12_malorita.kml"), "reg/p_12_malorita.txt"),
            Pair(GeoObject(13, "reg/r_13_pinsk.kml"), "reg/p_13_pinsk.txt"),
            Pair(GeoObject(14, "reg/r_14_pruzhanu.kml"), "reg/p_14_pruzhanu.txt"),
            Pair(GeoObject(15, "reg/r_15_stolin.kml"), "reg/p_15_stolin.txt"),
            Pair(GeoObject(16, "reg/r_16_zhabinka.kml"), "reg/p_16_zhabinka.txt"),
            Pair(GeoObject(17, "reg/r_17_oktyabrski.kml"), "reg/p_17_oktyabrski.txt"),
            Pair(GeoObject(18, "reg/r_18_brahin.kml"), "reg/p_18_brahin.txt"),
            Pair(GeoObject(19, "reg/r_19_buda-koshelevo.kml"), "reg/p_19_buda-koshelevo.txt"),
            Pair(GeoObject(20, "reg/r_20_chechersk.kml"), "reg/p_20_chechersk.txt"),
            Pair(GeoObject(21, "reg/r_21_dobrush.kml"), "reg/p_21_dobrush.txt"),
            Pair(GeoObject(22, "reg/r_22_homyel.kml"), "reg/p_22_homyel.txt"),
            Pair(GeoObject(23, "reg/r_23_kalinkovichi.kml"), "reg/p_23_kalinkovichi.txt"),
            Pair(GeoObject(24, "reg/r_24_korma.kml"), "reg/p_24_korma.txt"),
            Pair(GeoObject(25, "reg/r_25_khoiniki.kml"), "reg/p_25_khoiniki.txt"),
            Pair(GeoObject(26, "reg/r_26_loev.kml"), "reg/p_26_loev.txt"),
            Pair(GeoObject(27, "reg/r_27_lelchitsu.kml"), "reg/p_27_lelchitsu.txt"),
            Pair(GeoObject(28, "reg/r_28_mozyr.kml"), "reg/p_28_mozyr.txt"),
            Pair(GeoObject(29, "reg/r_29_narovlya.kml"), "reg/p_29_narovlya.txt"),
            Pair(GeoObject(30, "reg/r_30_petrikov.kml"), "reg/p_30_petrikov.txt"),
            Pair(GeoObject(31, "reg/r_31_rogachev.kml"), "reg/p_31_rogachev.txt"),
            Pair(GeoObject(32, "reg/r_32_rechitsa.kml"), "reg/p_32_rechitsa.txt"),
            Pair(GeoObject(33, "reg/r_33_svetlogorsk.kml"), "reg/p_33_svetlogorsk.txt"),
            Pair(GeoObject(34, "reg/r_34_vetka.kml"), "reg/p_34_vetka.txt"),
            Pair(GeoObject(35, "reg/r_35_elsk.kml"), "reg/p_35_elsk.txt"),
            Pair(GeoObject(36, "reg/r_36_zhlobin.kml"), "reg/p_36_zhlobin.txt"),
            Pair(GeoObject(37, "reg/r_37_zhitkovichi.kml"), "reg/p_37_zhitkovichi.txt"),
            Pair(GeoObject(38, "reg/r_38_oshmyanu.kml"), "reg/p_38_oshmyanu.txt"),
            Pair(GeoObject(39, "reg/r_39_ostrovets.kml"), "reg/p_39_ostrovets.txt"),
            Pair(GeoObject(40, "reg/r_40_berestovitsa.kml"), "reg/p_40_berestovitsa.txt"),
            Pair(GeoObject(41, "reg/r_41_dyatlovo.kml"), "reg/p_41_dyatlovo.txt"),
            Pair(GeoObject(42, "reg/r_42_hrodna.kml"), "reg/p_42_hrodna.txt"),
            Pair(GeoObject(43, "reg/r_43_ivye.kml"), "reg/p_43_ivye.txt"),
            Pair(GeoObject(44, "reg/r_44_korelichi.kml"), "reg/p_44_korelichi.txt"),
            Pair(GeoObject(45, "reg/r_45_lida.kml"), "reg/p_45_lida.txt"),
            Pair(GeoObject(46, "reg/r_46_mostu.kml"), "reg/p_46_mostu.txt"),
            Pair(GeoObject(47, "reg/r_47_novogrudok.kml"), "reg/p_47_novogrudok.txt"),
            Pair(GeoObject(48, "reg/r_48_svisloch.kml"), "reg/p_48_svisloch.txt"),
            Pair(GeoObject(49, "reg/r_49_shchuchin.kml"), "reg/p_49_shchuchin.txt"),
            Pair(GeoObject(50, "reg/r_50_slonim.kml"), "reg/p_50_slonim.txt"),
            Pair(GeoObject(51, "reg/r_51_smorgon.kml"), "reg/p_51_smorgon.txt"),
            Pair(GeoObject(52, "reg/r_52_volkovysk.kml"), "reg/p_52_volkovysk.txt"),
            Pair(GeoObject(53, "reg/r_53_voronovo.kml"), "reg/p_53_voronovo.txt"),
            Pair(GeoObject(54, "reg/r_54_zelva.kml"), "reg/p_54_zelva.txt"),
            Pair(GeoObject(55, "reg/r_55_osipovichi.kml"), "reg/p_55_osipovichi.txt"),
            Pair(GeoObject(56, "reg/r_56_bobruysk.kml"), "reg/p_56_bobruysk.txt"),
            Pair(GeoObject(57, "reg/r_57_belynichi.kml"), "reg/p_57_belynichi.txt"),
            Pair(GeoObject(58, "reg/r_58_byhov.kml"), "reg/p_58_byhov.txt"),
            Pair(GeoObject(59, "reg/r_59_chausu.kml"), "reg/p_59_chausu.txt"),
            Pair(GeoObject(60, "reg/r_60_cherikov.kml"), "reg/p_60_cherikov.txt"),
            Pair(GeoObject(61, "reg/r_61_dribin.kml"), "reg/p_61_dribin.txt"),
            Pair(GeoObject(62, "reg/r_62_glusk.kml"), "reg/p_62_glusk.txt"),
            Pair(GeoObject(63, "reg/r_63_gorki.kml"), "reg/p_63_gorki.txt"),
            Pair(GeoObject(64, "reg/r_64_kostyukovichi.kml"), "reg/p_64_kostyukovichi.txt"),
            Pair(GeoObject(65, "reg/r_65_hotimsk.kml"), "reg/p_65_hotimsk.txt"),
            Pair(GeoObject(66, "reg/r_66_kirovsk.kml"), "reg/p_66_kirovsk.txt"),
            Pair(GeoObject(67, "reg/r_67_klichev.kml"), "reg/p_67_klichev.txt"),
            Pair(GeoObject(68, "reg/r_68_klimovichi.kml"), "reg/p_68_klimovichi.txt"),
            Pair(GeoObject(69, "reg/r_69_krasnopolye.kml"), "reg/p_69_krasnopolye.txt"),
            Pair(GeoObject(70, "reg/r_70_krugloye.kml"), "reg/p_70_krugloye.txt"),
            Pair(GeoObject(71, "reg/r_71_krichev.kml"), "reg/p_71_krichev.txt"),
            Pair(GeoObject(72, "reg/r_72_mahilyow.kml"), "reg/p_72_mahilyow.txt"),
            Pair(GeoObject(73, "reg/r_73_mstislavl.kml"), "reg/p_73_mstislavl.txt"),
            Pair(GeoObject(74, "reg/r_74_shklov.kml"), "reg/p_74_shklov.txt"),
            Pair(GeoObject(75, "reg/r_75_slavgorod.kml"), "reg/p_75_slavgorod.txt"),
            Pair(GeoObject(76, "reg/r_76_borisov.kml"), "reg/p_76_borisov.txt"),
            Pair(GeoObject(77, "reg/r_77_berezino.kml"), "reg/p_77_berezino.txt"),
            Pair(GeoObject(78, "reg/r_78_cherven.kml"), "reg/p_78_cherven.txt"),
            Pair(GeoObject(79, "reg/r_79_dzerzhinsk.kml"), "reg/p_79_dzerzhinsk.txt"),
            Pair(GeoObject(80, "reg/r_80_kopyl.kml"), "reg/p_80_kopyl.txt"),
            Pair(GeoObject(81, "reg/r_81_kletsk.kml"), "reg/p_81_kletsk.txt"),
            Pair(GeoObject(82, "reg/r_82_krupki.kml"), "reg/p_82_krupki.txt"),
            Pair(GeoObject(83, "reg/r_83_logoysk.kml"), "reg/p_83_logoysk.txt"),
            Pair(GeoObject(84, "reg/r_84_lyuban.kml"), "reg/p_84_lyuban.txt"),
            Pair(GeoObject(85, "reg/r_85_molodechno.kml"), "reg/p_85_molodechno.txt"),
            Pair(GeoObject(86, "reg/r_86_minsk.kml"), "reg/p_86_minsk.txt"),
            Pair(GeoObject(87, "reg/r_87_myadel.kml"), "reg/p_87_myadel.txt"),
            Pair(GeoObject(88, "reg/r_88_nesvizh.kml"), "reg/p_88_nesvizh.txt"),
            Pair(GeoObject(89, "reg/r_89_puhovichi.kml"), "reg/p_89_puhovichi.txt"),
            Pair(GeoObject(90, "reg/r_90_soligorsk.kml"), "reg/p_90_soligorsk.txt"),
            Pair(GeoObject(91, "reg/r_91_slutsk.kml"), "reg/p_91_slutsk.txt"),
            Pair(GeoObject(92, "reg/r_92_smolevichi.kml"), "reg/p_92_smolevichi.txt"),
            Pair(GeoObject(93, "reg/r_93_starye dorogi.kml"), "reg/p_93_starye dorogi.txt"),
            Pair(GeoObject(94, "reg/r_94_stolbtsu.kml"), "reg/p_94_stolbtsu.txt"),
            Pair(GeoObject(95, "reg/r_95_uzda.kml"), "reg/p_95_uzda.txt"),
            Pair(GeoObject(96, "reg/r_96_volozhin.kml"), "reg/p_96_volozhin.txt"),
            Pair(GeoObject(97, "reg/r_97_vileyka.kml"), "reg/p_97_vileyka.txt"),
            Pair(GeoObject(98, "reg/r_98_orsha.kml"), "reg/p_98_orsha.txt"),
            Pair(GeoObject(99, "reg/r_99_braslav.kml"), "reg/p_99_braslav.txt"),
            Pair(GeoObject(100, "reg/r_100_beshenkovichi.kml"), "reg/p_100_beshenkovichi.txt"),
            Pair(GeoObject(101, "reg/r_101_chashniki.kml"), "reg/p_101_chashniki.txt"),
            Pair(GeoObject(102, "reg/r_102_dokshitsy.kml"), "reg/p_102_dokshitsy.txt"),
            Pair(GeoObject(103, "reg/r_103_dubrovno.kml"), "reg/p_103_dubrovno.txt"),
            Pair(GeoObject(104, "reg/r_104_gorodok.kml"), "reg/p_104_gorodok.txt"),
            Pair(GeoObject(105, "reg/r_105_glubokoye.kml"), "reg/p_105_glubokoye.txt"),
            Pair(GeoObject(106, "reg/r_106_lepel.kml"), "reg/p_106_lepel.txt"),
            Pair(GeoObject(107, "reg/r_107_liozno.kml"), "reg/p_107_liozno.txt"),
            Pair(GeoObject(108, "reg/r_108_mioru.kml"), "reg/p_108_mioru.txt"),
            Pair(GeoObject(109, "reg/r_109_postavu.kml"), "reg/p_109_postavu.txt"),
            Pair(GeoObject(110, "reg/r_110_polotsk.kml"), "reg/p_110_polotsk.txt"),
            Pair(GeoObject(111, "reg/r_111_rossonu.kml"), "reg/p_111_rossonu.txt"),
            Pair(GeoObject(112, "reg/r_112_sharkovshchina.kml"), "reg/p_112_sharkovshchina.txt"),
            Pair(GeoObject(113, "reg/r_113_shumilino.kml"), "reg/p_113_shumilino.txt"),
            Pair(GeoObject(114, "reg/r_114_senno.kml"), "reg/p_114_senno.txt"),
            Pair(GeoObject(115, "reg/r_115_tolochin.kml"), "reg/p_115_tolochin.txt"),
            Pair(GeoObject(116, "reg/r_116_ushachi.kml"), "reg/p_116_ushachi.txt"),
            Pair(GeoObject(117, "reg/r_117_vitsyebsk.kml"), "reg/p_117_vitsyebsk.txt"),
            Pair(GeoObject(118, "reg/r_118_verhnedvinsk.kml"), "reg/p_118_verhnedvinsk.txt"),

            Pair(GeoObject(1001, "obl/by_brest.kml"), "obl/brest.txt"),
            Pair(GeoObject(1002, "obl/by_vitebsk.kml"), "obl/vitebsk.txt"),
            Pair(GeoObject(1003, "obl/by_gomel.kml"), "obl/gomel.txt"),
            Pair(GeoObject(1004, "obl/by_grodno.kml"), "obl/grodno.txt"),
            Pair(GeoObject(1005, "obl/by_minsk.kml"), "obl/minsk.txt"),
            Pair(GeoObject(1006, "obl/by_mogilev.kml"), "obl/mogilev.txt")
        )
        val picker = FileGeoObjectPicker(map, context)
        picker.init()
        return picker
    }

    companion object {
        var INSTANCE: GeoObjectPicker? = null
    }

}
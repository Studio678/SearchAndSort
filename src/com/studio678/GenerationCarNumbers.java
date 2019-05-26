/*
     This class will generate ArrayList<String> of carNumbers
     author studio678 17.05.2019
 */

package com.studio678;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.pow;

class GenerationCarNumbers {

    static ArrayList<String> generationCarNumbers() {
        //get region codes ArrayList<> it will get 124 items in String type
        ArrayList<String> regions = extractRegions(REGIONS_TEXT);
        ArrayList<String> carMainDigits = generateCarMainDigits();
        ArrayList<String> carNumbers = new ArrayList<>();
        for (String carMainDigit : carMainDigits) {
            for (String coolLetter : COOL_LETTERS) {
                for (String region : regions) {
                    String str = coolLetter.substring(0, 1) + carMainDigit + coolLetter.substring(1, 3) + region;
                    carNumbers.add(str);
                }
            }
        }
        return carNumbers;
    }

    private static String MINIMAL_DIGIT_STRING = "000";
    private static String MAXIMAL_DIGIT_STRING = "999";

    private static ArrayList<String> generateCarMainDigits(){
        //function should return ArrayList<String> of main digits of car number, for example: "001"
        int minDigit = Integer.parseInt(MINIMAL_DIGIT_STRING);
        int maxDigit = Integer.parseInt(MAXIMAL_DIGIT_STRING);

        String digitsString;
        ArrayList<String> carMainDigits = new ArrayList<>();
        for(int digit = minDigit;digit<=maxDigit;digit++) {

            if (digit < 10) {
                //add two zero digits to string on two chars before digit
                digitsString = "00" + digit;
            } else if (digit < 100) {
                //add one zero digit to string on one char before digit
                digitsString = "0" + digit;
            } else {
                digitsString = Integer.toString(digit);
                //System.out.println(digitsString);
            }
            carMainDigits.add(digitsString);
        }
        return carMainDigits;
    }

    //extract substrings ArrayList<String> of region codes in car numbers
    private static ArrayList<String> extractRegions(String text){
        ArrayList<String> regions = new ArrayList<>();
        Matcher matcher = REGION_CODES_PATTERN.matcher(text);
        while (matcher.find()){
            regions.add(matcher.group());
            //System.out.println(regions.get(regions.size()-1));
        }
        return  regions;
    }



    //cool car numbers letters String array[]
    private final static String[] COOL_LETTERS = {"ААА", "ЕЕЕ", "СНМ", "ННН", "ССС", "РРР", "ООО", "ТТТ", "ННН",
            "ВНМ", "АНН" , "ТКА", "АНМ", "ЕНМ", "АЕТ", "КСК", "ОКО", "ВВВ", "ХХХ", "МКО", "АКО", "ЕКХ", "АКМ", "КУМ",
            "АКО", "МВД", "РТР", "ВОА", "МММ", "ККК" , "УУУ", "АОО", "СОР"};

    private final static Pattern REGION_CODES_PATTERN = Pattern.compile("(\\d{2,3})");

    private final static String REGIONS_TEXT = "01                                            Республика Адыгея\n" +
            "02, 102                                    Республика Башкортостан\n" +
            "03                                            Республика Бурятия\n" +
            "04                                            Республика Алтай\n" +
            "05                                            Республика Дагестан\n" +
            "06                                            Республика Ингушетия\n" +
            "07                                            Кабардино-Балкарская республика\n" +
            "08                                            Республика Калмыкия\n" +
            "09                                            Карачаево-Черкесская республика\n" +
            "10                                            Республика Карелия\n" +
            "11                                            Республика Коми\n" +
            "12                                            Республика Марий-Эл\n" +
            "13, 113                                    Республика Мордовия\n" +
            "14                                            Республика Саха (Якутия)\n" +
            "15                                            Республика Северная Осетия\n" +
            "16, 116                                    Республика Татарстан\n" +
            "17                                            Республика Тыва\n" +
            "18, 118                                    Удмуртская республика\n" +
            "19                                            Республика Хакасия\n" +
            "21, 121                                    Чувашская республика\n" +
            "22                                            Алтайский край\n" +
            "23, 93                                      Краснодарский край\n" +
            "24, 124                                    Красноярский край\n" +
            "25, 125                                    Приморский край\n" +
            "26                                            Ставропольский край\n" +
            "27                                            Хабаровский край\n" +
            "28                                            Амурская область\n" +
            "29                                            Архангельская область\n" +
            "30                                            Астраханская область\n" +
            "31                                            Белгородская область\n" +
            "32                                            Брянская область\n" +
            "33                                            Владимирская область\n" +
            "34                                            Волгоградская область\n" +
            "35                                            Вологодская область\n" +
            "36                                            Воронежская область\n" +
            "37                                            Ивановская область\n" +
            "38, 138                                    Иркутская область\n" +
            "39, 91                                      Калининградская область\n" +
            "40                                            Калужская область\n" +
            "41                                            Камчатская область\n" +
            "42                                            Кемеровская область\n" +
            "43                                            Кировская область\n" +
            "44                                            Костромская область\n" +
            "45                                            Курганская область\n" +
            "46                                            Курская область\n" +
            "47                                            Ленинградская область\n" +
            "48                                            Липецкая область\n" +
            "49                                            Магаданская область\n" +
            "50, 90, 150, 190, 750, 790      Московская область\n" +
            "51                                            Мурманская область\n" +
            "52, 152                                    Нижегородская область\n" +
            "53                                            Новгородская область\n" +
            "54, 154                                    Новосибирская область\n" +
            "55                                            Омская область\n" +
            "56                                            Оренбургская область\n" +
            "57                                            Орловская область\n" +
            "58                                            Пензенская область\n" +
            "59, 81, 159                              Пермский край\n" +
            "60                                            Псковская область\n" +
            "61, 161                                    Ростовская область\n" +
            "62                                            Рязанская область\n" +
            "63, 163                                    Самарская область\n" +
            "64, 164                                    Саратовская область\n" +
            "65                                            Сахалинская область\n" +
            "66, 96                                      Свердловская область\n" +
            "67                                            Смоленская область\n" +
            "68                                            Тамбовская область\n" +
            "69                                            Тверская область\n" +
            "70                                            Томская область\n" +
            "71                                            Тульская область\n" +
            "72                                            Тюменская область\n" +
            "73, 173                                    Ульяновская область\n" +
            "74, 174                                    Челябинская область\n" +
            "75                                            Читинская область\n" +
            "76                                            Ярославская область\n" +
            "77, 97, 99, 177, 197, 199,777,797  г. Москва\n" +
            "78, 98, 178                              г. Санкт-Петербург\n" +
            "79                                            Еврейская авт. область\n" +
            "80                                            Агинский Бурятский АО\n" +
            "82                                            Крым\n" +
            "83                                            Ненецкий АО\n" +
            "84                                            Таймырский (Долгано Ненецкий) АО\n" +
            "85                                            Усть-Ордынский Бурятский АО\n" +
            "86                                            Ханты-Мансийский АО\n" +
            "87                                            Чукотский АО\n" +
            "88                                            Эвенкийский АО\n" +
            "89                                            Ямало-Ненецкий АО\n" +
            "92                                            Севастополь\n" +
            "94                                            Территории, находящиеся за пределами РФ и обслуживаемые Департаментом режимных объектов МВД России (пример, Байконур)\n" +
            "95                                            Чеченская республика";

}

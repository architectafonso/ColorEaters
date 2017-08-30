package com.color.eaters;

/**
 * Created by João on 06/10/2016.
 * This one just stays here with the skeleton for a new levels package.
 */

class Levels_8 {
    /**
     * Returns the level.
     * @param level The level to be returned.
     * @return String[] with a string for each line and characters for each piece, plus the number of moves.
     */
    static String[] getLevel(int level) {
        switch (level) {
            case 1:
                return new String[] {
                        "   B  ",
                        "      ",
                        "   b  ",
                        "   n  ",
                        "      ",
                        "      ",
                        "2"
                };
            case 2:
                return new String[] {
                        "      ",
                        " bbb  ",
                        " b b  ",
                        " bbb  ",
                        "      ",
                        " N    ",
                        "1"
                };
            case 3:
                return new String[] {
                        "     T",
                        "bbb   ",
                        "b rbrr",
                        "bbrb r",
                        "   rrr",
                        "N     ",
                        "2"
                };
            case 4:
                return new String[] {
                        "      ",
                        "hhhhhg",
                        "nnnnh ",
                        "bbg h ",
                        "bbg h ",
                        "G  B  ",
                        "7"
                };
            case 5:
                return new String[] {
                        "T   B ",
                        "      ",
                        "nn  nn",
                        "tt  tt",
                        "      ",
                        "R    N",
                        "11"
                };
            case 6:
                return new String[] {
                        "h  B U",
                        "g  G N",
                        "n  R  ",
                        "b  W  ",
                        " rtyu ",
                        " weY  ",
                        "14"
                };
            case 7:
                return new String[] {
                        "rbywrw",
                        "b yrBg",
                        "gbwy b",
                        "  R  G",
                        "      ",
                        "TNUEH ",
                        "11"
                };
            case 8:
                return new String[] {
                        "      ",
                        "bryrwr",
                        "nnn nn",
                        "nnnnnn",
                        "  GYW ",
                        "  BNR ",
                        "15"
                };
            case 9:
                return new String[] {
                        "TYYggg",
                        "RbbrUg",
                        "Rb bgr",
                        "ybyr r",
                        "yHyrrr",
                        "yyy  N",
                        "4"
                };
            case 10:
                return new String[] {
                        "THTHTH",
                        "RWRBGY",
                        "  g   ",
                        "r gy  ",
                        "tbhy r",
                        "rbgywr",
                        "17"
                };
            case 11:
                return new String[] {
                        "Xwewwb",
                        "wXwryg",
                        "ewX   ",
                        "wTNX  ",
                        "GXWWX ",
                        "Y     ",
                        "30"
                };
            case 12:
                return new String[] {
                        "NBBBN ",
                        "      ",
                        "  n   ",
                        "  b   ",
                        "  n   ",
                        "  b   ",
                        "3"
                };
            case 13:
                return new String[] {
                        "rr  yy",
                        " yyrrt",
                        "XX    ",
                        "RY   r",
                        "      ",
                        "      ",
                        "14"
                };
            case 14:
                return new String[] {
                        "gggggg",
                        "ghhhhg",
                        "gggggg",
                        "      ",
                        "      ",
                        "    GH",
                        "3"
                };
            case 15:
                return new String[] {
                        "ggg   ",
                        "gRg   ",
                        "ggghhh",
                        "tttrrr",
                        "   rGr",
                        "   rrr",
                        "4"
                };
            case 16:
                return new String[] {
                        "brbrbr",
                        "rB   b",
                        "b NT r",
                        "r TN b",
                        "bR  Br",
                        "rbrbrb",
                        "10"
                };
            case 17:
                return new String[] {
                        "gygygy",
                        "      ",
                        "G    U",
                        "H    Y",
                        "      ",
                        "gygygy",
                        "10"
                };
            case 18:
                return new String[] {
                        "      ",
                        " brwy ",
                        " nnnn ",
                        " uuuu ",
                        " GWR  ",
                        "BUNTYR",
                        "10"
                };
            case 19:
                return new String[] {
                        "YgybrN",
                        "RbrwyT",
                        "BrbrbU",
                        "GbryyE",
                        "BrbybH",
                        "RbgrgT",
                        "15"
                };
            case 20:
                return new String[] {
                        " b  b ",
                        "X b   ",
                        "b   BX",
                        "  b   ",
                        "X    N",
                        "B b  X",
                        "6"
                };

            default:
                return new String[0];

        }
    }
}

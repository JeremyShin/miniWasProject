package studentapplication.dto;

public class Student {
    private String name;
    private int koreaScore;
    private int englishScore;
    private int mathmaticsScore;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKoreaScore() {
        return koreaScore;
    }

    public void setKoreaScore(int koreaScore) {
        this.koreaScore = koreaScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    public int getMathmaticsScore() {
        return mathmaticsScore;
    }

    public void setMathmaticsScore(int mathmaticsScore) {
        this.mathmaticsScore = mathmaticsScore;
    }
}

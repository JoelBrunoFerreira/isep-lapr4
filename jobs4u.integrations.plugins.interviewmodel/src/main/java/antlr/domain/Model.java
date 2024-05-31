package antlr.domain;

import java.util.List;

public class Model {
    private final String modelType;
    private final String title;
    private final String format;
    private final List<String> confFormat;
    private final String prefixAnswer;
    private int grade;
    private final List<Pair> answer;

    public Model(String modelType, String title, String format, List<String> confFormat, String prefixAnswer, int grade, List<Pair> answer) {
        this.modelType = modelType;
        this.title = title;
        this.format = format;
        this.confFormat = confFormat;
        this.prefixAnswer = prefixAnswer;
        this.grade = grade;
        this.answer = answer;
    }

    public Model(String modelType, String title, String format, List<String> confFormat, String prefixAnswer, List<Pair> answer) {
        this.modelType = modelType;
        this.title = title;
        this.format = format;
        this.confFormat = confFormat;
        this.prefixAnswer = prefixAnswer;
        this.answer = answer;
    }

    public String getModelType() {
        return modelType;
    }

    public String getTitle() {
        return title;
    }

    public String getFormat() {
        return format;
    }

    public List<String> getConfFormat() {
        return confFormat;
    }

    public String getPrefixAnswer() {
        return prefixAnswer;
    }

    public int getGrade() {
        return grade;
    }

    public List<Pair> getAnswer() {
        return answer;
    }
}

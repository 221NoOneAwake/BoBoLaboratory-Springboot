package cn.bobolaboratory.springboot.mapper;

import cn.bobolaboratory.springboot.dto.QuestionAddRequest;
import cn.bobolaboratory.springboot.entity.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Mapper
public interface QuestionMapper {
    /**
     * 添加单道判断题题目
     * @param questionAddRequest 要添加的题目
     */
    void insertJudgeQuestion(QuestionAddRequest questionAddRequest);

    /**
     * 添加单道选择题题目
     * @param questionAddRequest 要添加的题目
     */
    void insertChoiceQuestion(QuestionAddRequest questionAddRequest);

    /**
     * 后台根据题集id查询题目详情
     * @param questionSetId 题集id
     * @return 返回题目详情 包含 题目id 题目 类型 选项 答案 分值
     */
    List<Question> selectQuestionByQuestionSetIdFromBackEnd(Long questionSetId);

    /**
     * 学生获取试卷
     * @param questionSetId 题集id
     * @return 返回题目详情 包含 题目id 题目 类型 选项 分值
     */
    List<Question> selectQuestionByQuestionSetIdFromFrontEnd(Long questionSetId);

    /**
     * 获取评分信息
     * @param questionSetId 题集id
     * @return 返回题目详情 包含 题目id 题目类型 答案 分值
     */
    List<Question> selectAnswerByQuestionSetId(Long questionSetId);

    /**
     * 查询一个题集的总分
     * @param questionSetId 题集id
     * @return 返回总分
     */
    Integer countTotalScoreByQuestionSetId(Long questionSetId);

    /**
     * 修改题目信息
     * @param question 要修改的题目的信息
     */
    void updateQuestionByQuestionId(Question question);
}

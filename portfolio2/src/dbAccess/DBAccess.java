package dbAccess;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public interface DBAccess {

	/**
	 * DB�ւ̑�����s�����\�b�h<br>
	 * ���p�b�P�[�W�̂��ꂼ��̃N���X���I�[�o�[���C�h��<br>
	 * �����A�o�^�A�X�V�A�폜�Ȃǂ̗l�X�ȏ������s��<br>
	 * @param request
	 * @throws SQLException
	 */
	public void execute(HttpServletRequest request) throws SQLException;
}


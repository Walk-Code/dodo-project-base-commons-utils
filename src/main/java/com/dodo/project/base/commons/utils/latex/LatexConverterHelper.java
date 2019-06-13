package com.dodo.project.base.commons.utils.latex;

import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

/*
 * <b>LatexConverterHelper</b></br>
 *
 * <pre>
 * Latex码操作类
 * </pre>
 *
 * @Author xqyjjq walk_code@163.com
 * @Date 2019/6/13 17:41
 * @Since JDK 1.8
 */
public class LatexConverterHelper {
	private static final  Logger log = Logger.getLogger("LatexConverterHelper");

	public static String convertToImage(String latexStr) {
		String localTempFilePath = "";
		try {
			File tempFile = File.createTempFile("latex", ".png");

			convertToImage(tempFile, latexStr);
			localTempFilePath = tempFile.getAbsolutePath();
		} catch (Exception e) {
			log.severe("解析[" + latexStr + "]异常:"+ e.getMessage());
		}

		return localTempFilePath;
	}

	/*
	 * @Description: 转换成图片
	 * @Author: walk_code walk_code@163.com
	 * @Param: [imageFile, latexStr]
	 * @return: void
	 * @Date: 2019/6/13 17:47
	 */
	private static void convertToImage(File imageFile, String latexStr) throws Exception {
		TeXFormula formula = new TeXFormula(latexStr);

		TeXIcon icon = formula.new TeXIconBuilder().setStyle(TeXConstants.STYLE_DISPLAY).setSize(20).build();
		icon.setInsets(new Insets(5, 5, 5, 5));

		BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2 = image.createGraphics();
		g2.setColor(Color.white);
		g2.fillRect(0, 0, icon.getIconWidth(), icon.getIconHeight());

		JLabel jl = new JLabel();
		jl.setForeground(new Color(0, 0, 0));
		icon.paintIcon(jl, g2, 0, 0);

		ImageIO.write(image, "png", imageFile.getAbsoluteFile());
	}
}

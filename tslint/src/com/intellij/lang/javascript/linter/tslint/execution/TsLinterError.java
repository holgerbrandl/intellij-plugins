package com.intellij.lang.javascript.linter.tslint.execution;

import com.intellij.lang.javascript.integration.JSAnnotationRangeError;
import com.intellij.lang.javascript.linter.JSLinterError;
import com.intellij.lang.javascript.linter.tslint.highlight.TsLintFixInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Irina.Chernushina on 6/4/2015.
 */
public final class TsLinterError extends JSLinterError implements JSAnnotationRangeError {

  @Nullable
  private final String myPath;
  private final int myEndLine;
  private final int myEndColumn;

  @Nullable
  private final TsLintFixInfo myFixInfo;

  public TsLinterError(@Nullable String path,
                       int line,
                       int column,
                       int endLine,
                       int endColumn,
                       @NotNull String description,
                       @Nullable String code,
                       @Nullable TsLintFixInfo fixInfo) {
    super(line, column, description, code);
    myPath = path;
    myEndLine = endLine;
    myEndColumn = endColumn;
    myFixInfo = fixInfo;
  }

  @Override
  public int getEndLine() {
    return myEndLine;
  }

  @Override
  public int getEndColumn() {
    return myEndColumn;
  }

  @Nullable
  @Override
  public String getAbsoluteFilePath() {
    return myPath;
  }

  public boolean hasFix() {
    return myFixInfo != null;
  }

  @Nullable
  public TsLintFixInfo getFixInfo() {
    return myFixInfo;
  }
}

import React from 'react';
import { Prism as SyntaxHighlighter } from 'react-syntax-highlighter';
import { prism } from 'react-syntax-highlighter/dist/esm/styles/prism';

export default function Code({ language = 'javascript', style = prism, children}) {
  return (
    <SyntaxHighlighter language={language} showLineNumbers={true} style={style}>
      {children}
    </SyntaxHighlighter>
  )
}

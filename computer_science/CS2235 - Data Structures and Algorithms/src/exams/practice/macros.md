!def(question)(
    Figures created inside this environment are wide.
)(

```{=latex}
\question[!1]
```
!2
)

!def(solution)(
)(
```{=latex}
\begin{solution}[!1]
```

!2

```{=latex}
\end{solution}
```
)

!def(choices)()
(
```{=latex}
\begin{choices}
```
!1
```{=latex}
\end{choices}
```
)

!def(choice)()
(
  \choice !1  
)

!def(correct)()
(
  \CorrectChoice !1
)

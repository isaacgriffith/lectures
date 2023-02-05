import Data.Array

length' :: [a] -> Int
length' []     = 0
length' (x:xs) = 1 + length' xs

length'' :: [a] -> Int
length'' = foldr (\ x -> (+) 1) 0

sum' :: Num a => [a] -> a
sum' []     = 0
sum' (x:xs) = x + sum' xs

sum'' :: Num a => [a] -> a
sum'' = foldr (+) 0

zip' :: [a] -> [b] -> [(a, b)]
zip' [] ys = []
zip' xs [] = []
zip' (x:xs) (y:ys) = (x, y) : zip' xs ys

concat' :: [[a]] -> [a]
concat' [] = []
concat' (xs:xss) = xs ++ concat xss

max' :: (Ord a) => [a] -> a
max' [] = error "empty list"
max' [x] = x
max' (x:xs) =
  let mx = max' xs
  in if (x > mx) then x
     else mx

linSearch :: Eq a => [a] -> Int -> a -> Int
linSearch [] _ _ = 0
linSearch (y:ys) i x =
  if x == y then i
  else linSearch ys (i + 1) x

binSearch :: (Ord a) => [a] -> a -> Int -> Int -> Int
binSearch arr x lo hi
  | hi < lo = -1
  | pivot > x = binSearch arr x lo (mid - 1)
  | pivot < x = binSearch arr x (mid + 1) hi
  | otherwise =  mid
  where
    mid = lo + (hi - lo) `div` 2
    pivot = arr!!mid

insert' :: (Ord a) => a -> [a] -> [a]
insert' x [] = [x]
insert' x (y:ys)
  | x < y     = x:y:ys
  | otherwise = y : (insert' x ys)

isort :: (Ord a) => [a] -> [a]
isort []     = []
isort (x:xs) = insert' x (isort xs)

merge :: (Ord a) => [a] -> [a] -> [a]
merge [] [] = []
merge [] ys = ys
merge xs [] = xs
merge allX@(x:xs) allY@(y:ys)
  | x > y     = y : merge allX ys
  | otherwise = x : merge xs allY

msort :: (Ord a) => [a] -> [a]
msort [] = []
msort [a] = [a]
msort [a,b]
  | a > b     = [b, a]
  | otherwise = [a, b]
sort list =
  let split      = splitAt(length list `div` 2) list
      firstHalf  = msort (fst split)
      secondHalf = msort (snd split)
  in merge firstHalf secondHalf

qsort :: Ord a => [a] -> [a]
qsort [] = []
qsort (pivot:xs) =
  qsort [y | y <- xs, y < pivot]
  ++ [pivot]
  ++ qsort [y | y <- xs, y >= pivot]

match :: [Char] -> [Char] -> Int -> [Int]
match [] _ _ = []
match _ [] _ = []
match p allT@(t:ts) i =
  let
    l = length p
    n = take l allT
  in if (n == p) then i : (match p ts (i + 1))
     else match p ts (i + 1)

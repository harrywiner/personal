
import System.Random
import Data.Array.IO
import Control.Monad

-- Credit https://wiki.haskell.org/Random_shuffle
-- | Randomly shuffle a list
--   /O(N)/
shuffle :: [a] -> IO [a]
shuffle xs = do
        ar <- newArray n xs
        forM [1..n] $ \i -> do
            j <- randomRIO (i,n)
            vi <- readArray ar i
            vj <- readArray ar j
            writeArray ar j vi
            return vj
  where
    n = length xs
    newArray :: Int -> [a] -> IO (IOArray Int a)
    newArray n xs =  newListArray (1,n) xs

--execute :: [String] -> IO()
--execute xs = printStrLn (shuffle xs)




smashdown :: [String] -> [(String,String)]
smashdown [] = []
smashdown (sa:[]) = [(sa, "null")]
smashdown (sa:(sb:ss)) = (sa,sb) : smashdown ss

printZipped :: [([Char], [Char])] -> IO()
printZipped [] = putStrLn ""
printZipped (sa:ss) = do 
                        putStrLn ((fst  sa) ++ " VS "++ (snd sa))
                        printZipped ss 

--["Matio","Link","Peach","Donkey Kong"]
--["Matio","Link","Peach","Donkey Kong", "Lonk"]